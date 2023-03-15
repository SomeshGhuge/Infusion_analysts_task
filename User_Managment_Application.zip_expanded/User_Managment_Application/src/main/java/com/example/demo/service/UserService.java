package com.example.demo.service;

import com.example.demo.model.UserDetails;

public interface UserService  {
	
	public UserDetails CreateUser(UserDetails user);
	public boolean cheakEmail ( String email);

}
