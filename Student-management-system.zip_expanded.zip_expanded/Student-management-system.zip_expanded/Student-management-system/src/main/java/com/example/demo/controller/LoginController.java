package com.example.demo.controller;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;

@Controller
//@RequestMapping("/home")
public class LoginController {
	
	@Autowired
	public LoginService loginservice;
	
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("login",new Login());
		return  mav ; 
	}
		
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login) {
	Login nlogin= loginservice.login(login.getUsername(), login.getPassword());
	 
	if(Objects.nonNull(nlogin)) {
		return "redirect:/students" ;
	}
	else {
		return "redirect:/login";
	}
	
	
	
	}
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/home";
	}

}
