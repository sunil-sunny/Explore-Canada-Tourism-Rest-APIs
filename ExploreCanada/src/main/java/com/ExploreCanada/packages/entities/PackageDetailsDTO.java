package com.ExploreCanada.packages.entities;

public class PackageDetailsDTO {
	
	
	private int id;
	private double cost;
	private String image_url;
	private String destination;
	private String startDate;
	private String endDate;
	private String packageName;
	private String description;
	
	public PackageDetailsDTO(PackageDetails packageDetails) {
		
		this.id=packageDetails.getId();
		this.cost=packageDetails.getCost();
		this.image_url=packageDetails.getImage_url();
		this.destination =packageDetails.getDestination();
		this.startDate= packageDetails.getStartDate();
		this.endDate =packageDetails.getEndDate();
		this.packageName = packageDetails.getPackageName();
		this.description=packageDetails.getDescription();
		
		
	}
	public PackageDetailsDTO() {
		
	}
	
	public PackageDetailsDTO(int id, double cost, String image_url, String destination, String startDate,
			String endDate, String packageName, String description) {
		super();
		this.id = id;
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

}
