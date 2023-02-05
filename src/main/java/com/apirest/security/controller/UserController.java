package com.apirest.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.security.entities.User;
import com.aprest.security.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
    private UserService userService;
	
	@GetMapping("/home")
	public int home() {
		System.out.print("Welcome to app");
		return 2;
	}
	
	@GetMapping("/findAllUsers")
	public Iterable<User> findAllUsers() {
		return userService.findAll();
	}
	
	@PostMapping("/addUser")
	public User addUser(User user) {
		return userService.createUser(user);
	}
}
