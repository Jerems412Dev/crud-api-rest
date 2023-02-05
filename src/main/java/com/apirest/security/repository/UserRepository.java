package com.apirest.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.security.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
