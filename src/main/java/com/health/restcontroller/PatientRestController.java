package com.health.restcontroller;



import java.time.LocalDate;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.health.dto.AppointmentDto;
import com.health.dto.BillingDto;
import com.health.dto.InsurencePolicyDto;
import com.health.dto.MfaTokenData;
import com.health.dto.MfaVerificationRequest;
import com.health.dto.MfaVerificationResponse;
import com.health.dto.PatientDto;
import com.health.enumclass.PaymentStatus;
import com.health.model.Appointment;
import com.health.model.Billing;
import com.health.model.InsurencePolicy;
import com.health.model.Patient;
import com.health.service.IAppointmentService;
import com.health.service.IBillingService;
import com.health.service.IInsurencePolicyService;
import com.health.service.IPatientService;
import com.health.service.MailService;
import com.health.utility.AppointmentStatus;
import com.health.utility.StatusMsg;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import java.util.List;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/patient")
//@Secured("ROLE_PATIENT")    // applicable for only user with  patient role only
public class PatientRestController {

	@Autowired
	IPatientService patientService;
	
	@Autowired
	IAppointmentService appointmentService;
	
	
	@Autowired
	MailService mailService;
	
	@Autowired
	IBillingService billingService;
	
	
	@Autowired
	IInsurencePolicyService  iInsurencePolicyService;
	
	// patient operations

	@PostMapping("/save")
 public ResponseEntity<MfaTokenData> register(@RequestBody PatientDto patientDto) {

		MfaTokenData patient = patientService.addPatient(patientDto);
		return new ResponseEntity<MfaTokenData>(patient, HttpStatus.CREATED);

	}
	 @PostMapping("/verifyTotp")
	    public ResponseEntity<?> verifyTotp(@Validated @RequestBody MfaVerificationRequest request)  {
	      
	        MfaVerificationResponse mfaVerificationResponse=new MfaVerificationResponse(request.getUsername(), null, false, false, false, "token not valid");

	        // Validate the OTP
	        if(patientService.verifyTotp(request.getTotp(), request.getUsername())){
	          
		       MfaVerificationResponse mfaVerificationResponse2=new MfaVerificationResponse(request.getUsername(), null, false, false, true, "token is valid");
		        return ResponseEntity.ok(mfaVerificationResponse2);

	        }
	        return ResponseEntity.ok(mfaVerificationResponse);
	    }

	
	@GetMapping("/getpatient/{patientId}")
	@PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<Patient> getPatientDetails(@PathVariable Long patientId) {
		Patient patient = patientService.getPatient(patientId);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	@PutMapping("/updatepatient/{patientId}")
	public ResponseEntity<Patient> updatePatientDetails(@RequestBody PatientDto dto, @PathVariable Long patientId) {
		Patient patient = patientService.updatePatientDetails(dto, patientId);
		return ResponseEntity.ok().body(patient);
	}

	@PatchMapping("/updatenameandemail/{patientId}/{name}/{email}")
	public ResponseEntity<Patient> updatePatientDetails(@PathVariable Long patientId, @PathVariable String name,
			@PathVariable String email) {
		Patient patient = patientService.updateNameAndEmail(name, email, patientId);
		return ResponseEntity.ok().body(patient);
	}

	@DeleteMapping("/deletepatient/{patientId}")
	@PreAuthorize(" hasRole('ADMIN') and #patientId!=1 and hasAuthority('WRITE')" )   // evalues before this methoids execution
	public ResponseEntity<Patient> deletePatient(@PathVariable Long patientId,Authentication authentication) {
		System.out.println(authentication.getPrincipal()+"pr");
		Patient patient = patientService.deletePatientById(patientId);
		return ResponseEntity.ok().body(patient);
	}
	
	// Appointment && payment&& mail && bill generation
	
	@PostMapping("/bookappoint/{patientId}/{doctorId}")
	public ResponseEntity<AppointmentStatus> bookAppointment(@RequestBody AppointmentDto appointmentDto,@PathVariable Long patientId,@PathVariable Long doctorId){
		AppointmentStatus status=appointmentService.bookAppointment(appointmentDto,patientId,doctorId)	;
return ResponseEntity.ok(status);
	}
	
	@PostMapping("/makepayment/{patientId}/{appointmentId}/{appointmentMoney}")
	public ResponseEntity<?> generateOrderId(@PathVariable Long patientId,@PathVariable Long appointmentId,@PathVariable Double appointmentMoney) throws RazorpayException{

	Double insurenceAmount=iInsurencePolicyService.getInsurenceAmount(patientId);
	double amount=0;
	double appintmentMoney=appointmentMoney;
	RazorpayClient client=new RazorpayClient("rzp_test_X8z2oI4nPlT7Cw", "3ZOXat6SUQZ0wvrN5q3no4uh");
	JSONObject options=new JSONObject();
	if(insurenceAmount!=null) {
		if(insurenceAmount<=appintmentMoney)
		amount=appintmentMoney- insurenceAmount;
		else
			amount=insurenceAmount-appintmentMoney;
	}else {
		amount=appintmentMoney;
	}
	options.put("amount", amount);
	options.put("currency", "INR");
	options.put("receipt", "123r");
	Order o=client.Orders.create(options);
	System.out.println(o);
	
	// sending order id generating from razor pay to client with the url or only id
	 String paymentLink = "https://razorpay.com/payment-link/"+o.get("id");
	HttpHeaders header= new HttpHeaders();
	header.set("paymentLink", paymentLink);
	header.set("appointmentId", appointmentId.toString());
     return ResponseEntity.status(HttpStatus.FOUND).headers(header).body(new StatusMsg("payment link genrerated", LocalDate.now()));
	}
	
	@GetMapping("/afterpayment/{msg}/{amount}/{appointid}")
	@PostAuthorize("returnObject!=null")
	public ResponseEntity<?> afterPayment(@PathVariable String msg,@PathVariable Double amount,@PathVariable Long appointid) throws MessagingException
	{
		Appointment appointment=appointmentService.get(appointid);
		Billing b=new Billing(amount, PaymentStatus.valueOf(msg), "creditcard", LocalDate.now(),appointment );
	
		billingService.addBill(b);
	StatusMsg response=new StatusMsg("payment successed", LocalDate.now());
	return ResponseEntity.status(HttpStatus.OK).body(response);
}
	
	//Insurence
	
	@PostMapping("/savepolicy/{patientId}")
	public ResponseEntity<StatusMsg> addInsurence(@RequestBody InsurencePolicyDto insurencePolicy,@PathVariable Long patientId){
	StatusMsg response=iInsurencePolicyService.addInsurence(insurencePolicy, patientId);
	
	return new ResponseEntity<StatusMsg>(response, HttpStatus.OK);
	}
	
	@GetMapping("/generatebill/{appointmentId}")
	public ResponseEntity<BillingDto> generateBill(@PathVariable Long appointmentId){
		BillingDto dto=billingService.getBill(appointmentId);
		return new ResponseEntity<BillingDto>(dto,HttpStatus.OK);
	}

	@GetMapping("/generateallbill/{patientId}")
	@PreAuthorize("#patientId!=0 and hasAuthority('READ')")
	public ResponseEntity<List<BillingDto>> generateAllBill(@PathVariable Long patientId){
		List<BillingDto> dto=billingService.getAllBills(patientId);
		
		return new ResponseEntity<List<BillingDto>>(dto,HttpStatus.OK);
	}

	
}
