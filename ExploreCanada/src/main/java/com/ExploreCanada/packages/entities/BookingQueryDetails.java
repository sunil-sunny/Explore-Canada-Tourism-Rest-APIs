package com.ExploreCanada.packages.entities;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BookingQueryDetails {
	
	private String fromDetails;
	private String toDetails;
	@Temporal(TemporalType.DATE)
	private Date journeyDate;
	public BookingQueryDetails() {
		super(); 
	}
	public BookingQueryDetails(String fromDetails, String toDetails, Date journeyDate) {
		super();
		this.fromDetails = fromDetails;
		this.toDetails = toDetails;
		this.journeyDate = journeyDate;
	}
	public String getFromDetails() {
		return fromDetails;
	}
	public void setFromDetails(String fromDetails) {
		this.fromDetails = fromDetails;
	}
	public String getToDetails() {
		return toDetails;
	}
	public void setToDetails(String toDetails) {
		this.toDetails = toDetails;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	

}
