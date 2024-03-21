package com.health.securtyconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.health.filter.jwtFilter;
import com.health.service.MyUserdetailService;
import com.health.utility.CustomeProvider;
import com.health.utility.GoogleProvider;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)

public class SecurityConfiguration {

	@Autowired
	MyUserdetailService service;
	
	@Autowired
	jwtFilter filter;
	
	@Autowired
	CustomeProvider customeProvider;
	
	@Autowired
	GoogleProvider googleProvider;
	
	@Bean
	public AuthenticationManager manager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager(); 
		}
	
	
	
	@Autowired
	public void registerprovider(AuthenticationManagerBuilder builder) throws Exception
	{
// builder.userDetailsService(service);  it will use default doaauthe provide
 builder.authenticationProvider(customeProvider);
 builder.authenticationProvider(googleProvider);

	}	
	


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		System.out.println("Security filter chain");
		 httpSecurity.csrf(k->k.disable()).authorizeHttpRequests(requests->requests.
  
				 
				 // replacing by annoation based
//				requestMatchers("/api/patient/**").hasRole("PATIENT")
//				requestMatchers("/api/doctor/**").hasRole("DOCTOR").
//				.requestMatchers("/api/admin/**").hasRole("ADMIN").
				requestMatchers("/reg","/api/patient/save","/api/patient/verifyTotp").permitAll().
				

				anyRequest().authenticated()
				).sessionManagement(k->k.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)

				
				.httpBasic(entry->entry.authenticationEntryPoint(entryPoint())).formLogin();
				
				return httpSecurity.build();
		
	}
	
	@Bean
	public AuthenticationEntryPoint entryPoint() {
		return (request,response,exception)->
		{
			response.setStatus(401);
			response.getOutputStream().println("Please Login to acces Enetry Restricted");
		};
		}
	
	
	
	
	
	
	
	
	}
//	

