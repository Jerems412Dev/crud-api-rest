package com.apirest.security.entities;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idRole;
	 private String name;
	 @ManyToMany(mappedBy = "roles")
	  private Set<User> users;
	 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	 

}
