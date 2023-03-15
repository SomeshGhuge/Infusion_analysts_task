package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@PreAuthorize("hasRole('Normal')")
	@GetMapping("/normaluser")
	public ResponseEntity<String>NormalUser(){
		return ResponseEntity.ok("Yes I am Normal User");
	}
	
	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/adminuser")
	public ResponseEntity<String>AdminUser(){
		return ResponseEntity.ok("Yes I am Admin User");
	}
	
	@GetMapping("/publicuser")
	public ResponseEntity<String>PublicUser(){
		return ResponseEntity.ok("Yes I am Public User");
	}

}
