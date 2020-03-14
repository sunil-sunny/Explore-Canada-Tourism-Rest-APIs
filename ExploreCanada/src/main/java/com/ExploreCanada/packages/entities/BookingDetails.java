package com.ExploreCanada.packages.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="booking_details")
public class BookingDetails {
	
	@Id
	@Column(name="ticket_id")
	private String bookingID;
	@Column(name="customer_id")
	private String customerID;
	@Column(name="from_place")
	private String fromPlace;
	@Column(name="to_place")
	private String toPlace;
	@Temporal(TemporalType.DATE)
	private Date journeyDate;
	
	public BookingDetails(String bookingID, String customerID, String fromPlace, String toPlace, Date journeyDate) {
		super();
		this.bookingID = bookingID;
		this.customerID = customerID;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.journeyDate = journeyDate;
	}

	public BookingDetails(BookDetailsDTO bookDetailsDTO) {
		this.bookingID=bookDetailsDTO.getBookingID();
		this.customerID=bookDetailsDTO.getCustomerID();
		this.fromPlace=bookDetailsDTO.getFromPlace();
		this.toPlace=bookDetailsDTO.getToPlace();
		this.journeyDate=bookDetailsDTO.getJourneyDate();
	}
	public BookingDetails() {
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
