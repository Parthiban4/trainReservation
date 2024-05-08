package com.cts.project.trainReservation.Dto;

public class LoginDetails {
	
	private String email;
	private String password;
	
	public LoginDetails(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
