package com.health.utility;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.health.model.Permissions;
import com.zaxxer.hikari.util.ClockSource.MillisecondClockSource;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

	
	
	   
	    private String secret="Vishwa";

//	    @Value("${jwt.expiration}")
//	    private long expiration;

	    public String generateToken(UserDetails userDetails) {
	       List<String> roles=userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
	    
	        Date now = new Date();
	        Date expirationDate = new Date(now.getTime()+(1000*60*60*24));
	        System.out.println(expirationDate);
	        List<String> permissions=new ArrayList<>();
	        permissions.add(Permissions.READ.toString());
	        permissions.add(Permissions.UPDATE.toString());
System.out.println("role"+roles);

if(roles.get(0).equals("ADMIN")) {
	System.out.println("dd");
	permissions.add(Permissions.WRITE.toString());
	permissions.add(Permissions.DELETE.toString());

}
System.out.println("tokengen");

	        return Jwts.builder()
	                .claim("roles",roles)
	                .claim("permissions", permissions)
	                .setSubject(userDetails.getUsername())
	                .setIssuedAt(now)
	                .setExpiration(expirationDate)
	                .signWith(SignatureAlgorithm.HS256, secret)
	                .compact();
	    }

	    public String extractUsername(String token) {
	        String res=extractClaims(token).getSubject();
	    	System.out.println(res);
	    	return res;

	    }

	    public List<String> extractRoles(String token) {
	        Claims claims = extractClaims(token);
	        return (List<String>) claims.get("roles");
	    }
	    public List<String> extractPermission(String token) {
	        Claims claims = extractClaims(token);
	        return (List<String>) claims.get("permissions");
	    }
	    public Date extractExpiration(String token) {
	        Date d= extractClaims(token).getExpiration();
	        System.out.println(d);
	        return d;
	    }

	    public boolean isTokenExpired(String token) {
	        boolean b= extractExpiration(token).before(new Date());
	        System.out.println(b);
	        return b;
	    }

	    private Claims extractClaims(String token) {
	        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	    }

	    public boolean validateToken(String token, UserDetails userDetails) {
	    	System.out.println(token);
	        final String username = extractUsername(token);
	        boolean check= (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	   System.out.println("validate"+check);
	   System.out.println(username+"  user "+userDetails.getUsername());
	   return check;
	    }
	    
	   
	}


