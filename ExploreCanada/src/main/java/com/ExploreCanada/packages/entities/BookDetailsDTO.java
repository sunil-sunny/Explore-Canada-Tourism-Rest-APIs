package com.ExploreCanada.packages.entities;



import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BookDetailsDTO {
	
	private String bookingID;
	private String customerID;
	private String fromPlace;
	private String toPlace;
	@Temporal(TemporalType.DATE)
	private Date journeyDate;
	public BookDetailsDTO(String bookingID, String customerID, String fromPlace, String toPlace, Date journeyDate) {
		super();
		this.bookingID = bookingID;
		this.customerID = customerID;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.journeyDate = journeyDate;
	}
	public BookDetailsDTO() {
		super();
	}
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
}
