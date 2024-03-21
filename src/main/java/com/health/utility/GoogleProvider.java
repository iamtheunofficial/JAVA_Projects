package com.health.utility;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


//3 rd party provider for authentication like they exist in their database or  not


@Component
public class GoogleProvider implements AuthenticationProvider {

	@Autowired
	PasswordEncoder encoder;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	String username=String.valueOf(authentication.getPrincipal());
	String password=String.valueOf(authentication.getCredentials());
	
UserDetails userDetails=googleloadByUserName(username);
if(userDetails!=null && encoder.matches(password, userDetails.getPassword())) {
	UsernamePasswordAuthenticationToken returnauthentication=new UsernamePasswordAuthenticationToken(password, userDetails, userDetails.getAuthorities());
return returnauthentication;
}
throw new UsernameNotFoundException("Inavlid username and password");

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

	public UserDetails googleloadByUserName(String username) {
		return new User("vishwa", encoder.encode("321"), new ArrayList<>());
	}
}


