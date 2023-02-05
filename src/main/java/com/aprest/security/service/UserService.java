package com.aprest.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.security.entities.User;
import com.apirest.security.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;

@Data
@Service
public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//create user
	public User createUser(User user) {
		return userRepository.save(user);
    }
	
	//update user
	public User updateUser(int id, User updatedUser) {
		Optional<User> existingUser = userRepository.findById(id);
        if (!existingUser.isPresent()) {
            throw new EntityNotFoundException("User not found with id " + id);
        }

        User user = existingUser.get();
        user.setFirstname(updatedUser.getFirstname());
        user.setLastname(updatedUser.getLastname());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        return userRepository.save(user);
	}
	
	//delete user
	public void deleteUser(int id) {
		Optional<User> existingUser = userRepository.findById(id);
        if (!existingUser.isPresent()) {
            throw new EntityNotFoundException("User not found with id " + id);
        }
        User user = existingUser.get();
        userRepository.delete(user);
	}
	
	//find all user
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	//find user by id
	public User findUserById(int id) {
		Optional<User> existingUser = userRepository.findById(id);
        if (!existingUser.isPresent()) {
            throw new EntityNotFoundException("User not found with id " + id);
        }
        User user = existingUser.get();
        return user;
	}
	
	
}
