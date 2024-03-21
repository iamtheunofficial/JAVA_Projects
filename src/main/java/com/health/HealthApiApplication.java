package com.health;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;

import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.CodeVerifier;
import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.DefaultCodeVerifier;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;

@SpringBootApplication
public class HealthApiApplication {

	
	 @Bean
	    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
	 @Bean
	    public SecretGenerator secretGenerator(){
	        return new DefaultSecretGenerator();
	    }

	    @Bean
	    public QrGenerator qrGenerator(){
	        return new ZxingPngQrGenerator();
	    }

	    @Bean
	    public CodeVerifier myCodeVerifier(){
	        // Time
	        TimeProvider timeProvider = new SystemTimeProvider();
	        // Code Generator
	        CodeGenerator codeGenerator = new DefaultCodeGenerator(HashingAlgorithm.SHA512, 6);
	        DefaultCodeVerifier codeVerifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
	        codeVerifier.setTimePeriod(600);
	        codeVerifier.setAllowedTimePeriodDiscrepancy(2);
	        return  codeVerifier;
	    }
	
	    
	    
	    
	    
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
		ApplicationContext context=SpringApplication.run(HealthApiApplication.class, args);
//	AuthenticationManager amanger=context.getBean(AuthenticationManager.class);
//	System.out.println(amanger);
		String secretKey="XPZU223LPUNM4CKBBMVFKTD7PJDCHLXV";
		byte[] decodeKey=Base64.getDecoder().decode(secretKey.getBytes());
	SecretKeySpec key=new SecretKeySpec(decodeKey, "HmacSHA1");
	TimeBasedOneTimePasswordGenerator totpGenerator=new TimeBasedOneTimePasswordGenerator();
	long currentTimeSeconds=Instant.now().getEpochSecond();
	System.out.println("otp ="+ totpGenerator.generateOneTimePassword(key, currentTimeSeconds));
	
	}

}
