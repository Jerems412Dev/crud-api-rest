package com.aprest.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.security.entities.Role;
import com.apirest.security.repository.RoleRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;

@Data
@Service
public class RoleService {
	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	//create role
	public Role createRole(Role role) {
		return roleRepository.save(role);
    }
	
	//update role
	public Role updateRole(int id, Role updatedRole) {
		Optional<Role> existingRole = roleRepository.findById(id);
        if (!existingRole.isPresent()) {
            throw new EntityNotFoundException("Role not found with id " + id);
        }

        Role role = existingRole.get();
        role.setName(updatedRole.getName());

        return roleRepository.save(role);
	}
	
	//find all role
		public List<Role> findAll() {
			return roleRepository.findAll();
		}

}
