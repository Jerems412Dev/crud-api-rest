package com.apirest.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.security.entities.Role;
import com.aprest.security.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {
	@Autowired
    private RoleService roleService;
	
	@GetMapping("/findAllRoles")
	public Iterable<Role> findAllRoles() {
		return roleService.findAll();
	}
	
	@PostMapping("/addRole")
	public Role addUser(Role role) {
		return roleService.createRole(role);
	}
}
