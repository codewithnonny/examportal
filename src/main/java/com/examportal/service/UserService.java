package com.examportal.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.modal.User;
import com.examportal.modal.UserRole;
import com.examportal.repository.RoleRepository;
import com.examportal.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	
	//create user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception {
		
		User local = userRepository.findByUsername(user.getUsername());
	
		if (local != null) {
			System.out.println("user already created");
			throw new Exception("user is already present");
		} else {
			//create user
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = userRepository.save(user);
		}
		
		return local;
	}
	
	///get user
	
	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	
	
	
}