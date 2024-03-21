package com.health.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.health.model.User;


public class MyUserDetails  implements UserDetails{

	private String username;
	private String password;
	private boolean active;
	private String role;
	
	public MyUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public MyUserDetails(User user) {
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.active=user.isEnabled();
		this.role=user.getRole().getRoleName();
	
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return  authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return 
				password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

	@Override
	public String toString() {
		return "MyUserDetails [username=" + username + ", password=" + password + ", active=" + active + ", role="
				+ role + "]";
	}

}
