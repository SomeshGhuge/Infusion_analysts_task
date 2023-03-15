package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping("/createUser")
	public String CreateUser(@ModelAttribute UserDetails user,HttpSession session) {
		// http session used for the show msg on web
		
		boolean f=service.cheakEmail(user.getEmail());
		
		if(f) {
			session.setAttribute("msg", "Email Id already exists");
			System.out.println("This user already exists");
		}else {
			UserDetails userdetails=service.CreateUser(user);
	
			if(userdetails!=null) {
				session.setAttribute("msg", "Sucessfully Registered");
			}else {
				session.setAttribute("msg", "Not registered error i  server");
			}
			
		}
		
		
		
		return "redirect:/registration";
	}

}
