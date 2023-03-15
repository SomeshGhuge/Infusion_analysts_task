package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	private String fullname;
	private String email;
	private String address;
	private String qualification;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDetails(int id, String fullname, String email, String address, String qualification, String password) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.qualification = qualification;
		this.password = password;
	}
	public UserDetails() {
		
	}
	
	
	

}
