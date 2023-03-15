package com.example.demo.appconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class securityconfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	Used for app details username password
//	@Bean
//	public UserDetailsService userDetailService() {
//		
//		UserDetails normalUser=User.withUsername("Normal").password(passwordEncoder().encode("Somya@123")).roles("Normal").build();
//		UserDetails adminUser=User.withUsername("Admin").password(passwordEncoder().encode("Somya@123")).roles("Admin").build();
//		
//		// InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager();
//	
//	 return new InMemoryUserDetailsManager(normalUser,adminUser);		
//   }
	
	
	
	//Used for database stored username and Passwords
		@Bean
	public UserDetailsService userDetailService() {
	
	 return new CustomUserDetailService();		
   }
	

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity httpsecurity) throws Exception {
		
		httpsecurity.csrf().disable()
		.authorizeHttpRequests()
//		.requestMatchers("/home/adminuser/**")
//		.hasRole("Admin")
//		.requestMatchers("/home/normaluser")
//		.hasRole("Normal")
		.requestMatchers("/home/publicuser")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
	    return httpsecurity.build();
		
	}

}
