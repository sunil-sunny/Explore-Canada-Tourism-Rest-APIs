package com.ExploreCanada.packages.entities;


import java.sql.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class CustomerDetailsDTO {
	
	@NotNull(message = "userId can not be null")
	@NotEmpty(message = "userId can not be empty")
	private String userId;
	@NotNull(message = "First Name can not be null")
	@NotEmpty(message = "First name can not be empty")
	private String firstName;
	@NotNull(message = "userId can not be null")
	@NotEmpty(message = "userId can not be empty")
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String address;
	private String country;
	private String pinCode;
	//@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	//@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	private String securityAnswer;
	public CustomerDetailsDTO() {
		
		super();
	}
	public CustomerDetailsDTO(String userId, String firstName, String lastName, Date dateOfBirth, String address,
			String country, String pinCode, String password, String securityAnswer) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.country = country;
		this.pinCode = pinCode;
		this.password = password;
		this.securityAnswer = securityAnswer;
	}
	
	public CustomerDetailsDTO(CustomerDetails customerDetails) {
		super();
		this.userId = customerDetails.getUsername();
		this.firstName = customerDetails.getFirstName();
		this.lastName = customerDetails.getLastName();
		this.dateOfBirth = (Date) customerDetails.getDateOfBirth();
		this.address = customerDetails.getAddress();
		this.country = customerDetails.getCountry();
		this.pinCode = customerDetails.getPinCode();
		this.password = customerDetails.getPassword();
		this.securityAnswer = customerDetails.getSecurityAnswer();
		//this.role = "user";
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	@Override
	public String toString() {
		return "CustomerDetailsDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", country=" + country + ", pinCode="
				+ pinCode + ", password=" + password + ", securityAnswer=" + securityAnswer + "]]";
	}

}
