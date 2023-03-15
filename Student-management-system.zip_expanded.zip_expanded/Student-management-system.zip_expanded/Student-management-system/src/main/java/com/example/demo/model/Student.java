package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	@Column (name="first_name")
	private String firstname;
	@Column (name="last_name" )
	private String lastname;
	@Column (name="emial" )
	private String email;
	@Column(name="seatno")
	private int seatNo;
	@Column(name="dob")
	private String dob;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student( String firstname, String lastname, String email,int seatNo,String dob) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob=dob;
		this.seatNo=seatNo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", seatNo=" + seatNo + ", dob=" + dob + "]";
	}
	

}
