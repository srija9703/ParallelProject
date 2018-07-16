package com.cg.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Account {
	private String phoneNumber;
	private String name;
	private String email;
	private double balance;
	private LocalDateTime date;
	
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Account(String phoneNumber, String name, String email, double balance) {
//		super();
//		this.phoneNumber = phoneNumber;
//		this.name = name;
//		this.email = email;
//		this.balance = balance;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Account(String phoneNumber, String name, String email,
			double balance, LocalDateTime date) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.date = date;
	}
	public Account() {
		super();
	}
	
	

}
