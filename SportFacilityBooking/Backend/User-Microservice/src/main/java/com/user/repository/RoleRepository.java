package com.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.ERole;
import com.user.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	
  Optional<Role> findByName(ERole name);
  
}