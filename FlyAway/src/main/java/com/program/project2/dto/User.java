package com.program.project2.dto;

public class User {

	// class User to store all the information about the customer
	
	private String firstName;
	private String lasttName;
	private String passportNumber;
	private String email;
	private String password;
	private String address;
	private String city;
	private String state;
	private String zipCode;

	public User() {
		
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lasttName=" + lasttName + ", passportNumber=" + passportNumber
				+ ", email=" + email + ", password=" + password + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

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

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
