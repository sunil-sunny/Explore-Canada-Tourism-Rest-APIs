package com.ExploreCanada.packages.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="package_details")
public class PackageDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="package_id")
	private int id;
	@Column(name="cost")
	private double cost;
	@Column(name="image_url")
	private String image_url;
	@Column(name="destination")
	private String destination;
	@Column(name="start_date")
	private String startDate;
	@Column(name="end_date")
	private String endDate;
	@Column(name="package_name")
	private String packageName;
	@Column(name="package_description")
	private String description;
	public PackageDetails() {
		
	}
	public PackageDetails(double cost, String image_url, String destination, String startDate, String endDate,
			String packageName, String description) {
		super();
		this.cost = cost;
		this.image_url = image_url;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.packageName = packageName;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PackageDetails [id=" + id + ", cost=" + cost + ", image_url=" + image_url + ", destination="
				+ destination + ", startDate=" + startDate + ", endDate=" + endDate + ", packageName=" + packageName
				+ ", description=" + description + "]";
	}

}
