package com.health.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.health.service.MyUserdetailService;

// providing custom provider instead of daoauthentication provider which is being used as default autentication provider

@Component
public class CustomeProvider  implements AuthenticationProvider{

	@Autowired
	MyUserdetailService myUserdetailService;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username=String.valueOf(authentication.getPrincipal());
		String password=String.valueOf(authentication.getCredentials());
		System.out.println("username"+password);
		UserDetails userDetails=myUserdetailService.loadUserByUsername(username);
		if(userDetails!=null && encoder.matches(password, userDetails.getPassword())) {
			UsernamePasswordAuthenticationToken returnauthentication=new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
		return returnauthentication;
		}
throw new UsernameNotFoundException("Inavlid username and password");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
