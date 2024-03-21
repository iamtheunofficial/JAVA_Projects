package com.health.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.health.model.Role;
import com.health.repositories.UserRepo;

@Service
public class MyUserdetailService implements UserDetailsService {
	@Autowired
UserRepo repo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Optional<com.health.model.User> o=repo.findByusername(username);
		if(o.isPresent()) {
			com.health.model.User u=o.get();
		System.out.println(u.getPassword());
		List<GrantedAuthority> authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(u.getRole().getRoleName()));
//		authorities.add(new SimpleGrantedAuthority("WRITE"));
//		if(u.getRole().getRoleName().equals("ADMIN")) {
//			authorities.add(new Sim)
//		}
		System.out.println("comes");
		return new User(u.getUsername(), u.getPassword(),authorities);
//			return new MyUserDetails(new com.health.model.User(u.getUsername(),u.getPassword(), new Role(u.getRole().getRoleName()), u.isEnabled()));
	}
		System.out.println("optional "+o);
		throw new UsernameNotFoundException("user not found");
	
	}

}
