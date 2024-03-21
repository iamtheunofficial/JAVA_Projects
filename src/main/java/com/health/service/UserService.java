package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.User;
import com.health.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;
	public User save(User u) {
		
		return repo.save(u);
	}
	
	public User findByName(String name) {
		return repo.findByusername(name).get();
	}

}
