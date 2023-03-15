package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails CreateUser(UserDetails user) {	
		return repo.save(user);
	}

	
	public boolean cheakEmail(String email) {
		return repo.existsByEmail(email);
		
	}

}
