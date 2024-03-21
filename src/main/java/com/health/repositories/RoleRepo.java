package com.health.repositories;

import org.springframework.data.repository.CrudRepository;

import com.health.model.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {

}
