package model;

import java.time.LocalDate;

//Create a model class called User with the following parameters.
//- private String email - private String password	- private LocalDate date
//Include appropriate getters and setters.

public class User {
	private String email;
	private String password;
	private LocalDate date;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
