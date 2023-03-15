package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	public LoginRepository repo;
	
	public Login login(String username, String password) {
		Login login=repo.findByUsernameAndPassword(username, password);
		return login;
	}

}
