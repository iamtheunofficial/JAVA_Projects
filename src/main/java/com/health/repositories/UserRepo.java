package com.health.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.health.model.User;

public interface UserRepo extends CrudRepository<User, Long> {

	public Optional<User> findByusername(String username);
}
