package com.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.modal.Role;
import com.examportal.modal.User;
import com.examportal.modal.UserRole;
import com.examportal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User userRegistration(@RequestBody User user) throws Exception {
		
		
		//role
		Role role = new Role();
		role.setRoleName("NORMAL");
		
		//userrole
		UserRole userRoles = new UserRole();
		userRoles.setUser(user);
		userRoles.setRole(role);
		
		//userroleset
		Set<UserRole> userRoleSet = new HashSet<UserRole>();
		userRoleSet.add(userRoles);
		
		User u1 = userService.createUser(user, userRoleSet);
		
		return u1;
	}
	
	@GetMapping("/{username}")
	public User fetchUserByUsername(@PathVariable("username") String username) {
		User user = userService.getUserByUsername(username);
		return user;
	}
	
}
