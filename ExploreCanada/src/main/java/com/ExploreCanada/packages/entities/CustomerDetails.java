package com.ExploreCanada.packages.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer_details")
public class CustomerDetails {
	
	@Id
	@Column(name="user_id",nullable = false)
	private String username;
	@Column(name="first_name",nullable = false)
	private String firstName;
	@Column(name="last_name",nullable = false)
	private String lastName;
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column(name="address")
	private String address;
	@Column(name="country")
	private String country;
	@Column(name="pin_code")
	private String pinCode;
	@Column(name="password")
	private String password;
	@Column(name="security_answer")
	private String securityAnswer;
	@Column(name="role")
	private String role;
	
	public CustomerDetails() {
      super();
    }
	public CustomerDetails(String userId, String firstName, String lastName, Date dateOfBirth, String address,
			String country, String pinCode, String password, String securityAnswer, String role) {
		super();
		this.username = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.country = country;
		this.pinCode = pinCode;
		this.password = password;
		this.securityAnswer = securityAnswer;
		this.role = role;
	}
	
	public CustomerDetails(CustomerDetailsDTO customerDetailsDTO) {
		super();
		this.username = customerDetailsDTO.getUserId();
		this.firstName = customerDetailsDTO.getFirstName();
		this.lastName = customerDetailsDTO.getLastName();
		this.dateOfBirth = customerDetailsDTO.getDateOfBirth();
		this.address = customerDetailsDTO.getAddress();
		this.country = customerDetailsDTO.getCountry();
		this.pinCode = customerDetailsDTO.getPinCode();
		this.password = customerDetailsDTO.getPassword();
		this.securityAnswer = customerDetailsDTO.getSecurityAnswer();
		this.role = "user";
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String userId) {
		this.username = userId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "CustomerDetails [userId=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", country=" + country + ", pinCode="
				+ pinCode + ", password=" + password + ", securityAnswer=" + securityAnswer + ", role=" + role + "]";
	}
	
}
