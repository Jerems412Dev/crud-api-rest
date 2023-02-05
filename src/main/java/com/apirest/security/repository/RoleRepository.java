package com.apirest.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.security.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
