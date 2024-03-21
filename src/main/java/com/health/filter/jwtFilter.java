package com.health.filter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.health.service.MyUserdetailService;
import com.health.utility.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class jwtFilter extends OncePerRequestFilter{

	@Autowired
	private MyUserdetailService myUserdetailService;
	@Autowired
	private JwtUtil jwtUtil;
   

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException
	{
		String authorization=request.getHeader("Authorization");
	String username=null;
	String jwt=null;
	if(authorization!=null && authorization.startsWith("Bearer")) {
		System.out.println("blaaaaaa");
		jwt=authorization.substring(7);
		username=jwtUtil.extractUsername(jwt);
	}
	if(username!=null) {
		UserDetails userDetails=myUserdetailService.loadUserByUsername(username);
		
		if(jwtUtil.validateToken(jwt, userDetails)) {
//			System.out.println("details"+userDetails);
//			System.out.println(userDetails.getAuthorities());
	List<String> roles=jwtUtil.extractRoles(jwt);
	List<String> permission=jwtUtil.extractPermission(jwt);
//	System.out.println("per"+permission);

	List<SimpleGrantedAuthority> authrities=roles.stream().map(k->new SimpleGrantedAuthority("ROLE_"+k)).collect(Collectors.toList());
authrities.addAll(permission.stream().map(k->new SimpleGrantedAuthority(k)).toList());
	UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,null,authrities);
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//		}
	}

	}
	filterChain.doFilter(request, response);
	}
}



