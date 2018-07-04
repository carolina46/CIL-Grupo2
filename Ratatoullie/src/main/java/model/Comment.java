package model;

import java.time.LocalDateTime;

/**
 * Represents a comment from a user about a restaurant
 * 
 * @author CIL-Grupo2
 */


public class Comment {

	private Long oid;
	private String description;
	private LocalDateTime date;
	private Restaurant restaurant;
	private boolean notified;
	
	public Comment(String description, Restaurant restaurant, Client client) {
		this.description = description;
		this.restaurant = restaurant;
		this.date = LocalDateTime.now();
		this.notified = false;
	}
	
	public Long getOid() {	return oid;}
	public void setOid(Long oid) {	this.oid = oid;}
	
	//Methods associated with Date
	public LocalDateTime getDate() {	return date;}
	public void setDate(LocalDateTime date) { this.date = date;}
	
	//Methods associated with Description
	public String getDescription() { return description;}
	public void setDescription(String description) { this.description = description;}
	
	//Methods associated with Restaurant
	public Restaurant getRestaurant() {		return restaurant;	}
	public void setRestaurant(Restaurant restaurant) {	this.restaurant = restaurant;	}

	public boolean isNotified() {return notified;}
	public void setNotified(boolean notified) {this.notified = notified;}
}
