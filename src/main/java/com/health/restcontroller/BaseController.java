package com.health.restcontroller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.health.service.MyUserdetailService;
import com.health.service.UserService;
import com.health.utility.AuthenticationRequest;
import com.health.utility.JwtUtil;

@RestController
public class BaseController {

	
	@Autowired
	AuthenticationManager  authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	MyUserdetailService service;

	
	@PostMapping("/reg")
public ResponseEntity<?> login(@RequestBody AuthenticationRequest request){
		System.out.println("ssssss");
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		UserDetails user=service.loadUserByUsername(request.getUsername());
		System.out.println(user);
		String token=jwtUtil.generateToken(user);
		HttpHeaders header= new HttpHeaders();
		header.set("jwtToken", token);
		return  ResponseEntity.ok().headers(header).build();
}
	

}
