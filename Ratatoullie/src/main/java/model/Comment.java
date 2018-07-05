package model;

import java.time.LocalDateTime;

import model.business.Restaurant;
import model.users.Client;

/**
 * Represents a comment from a user about a restaurant
 * 
 * @author CIL-Grupo2
 */

public class Comment {

	private Long oid; //For Hibernate
	private String description;
	private LocalDateTime date;
	private Restaurant restaurant;
	
	public Comment() {} //For Hibernate
	
	public Comment(String description, Restaurant restaurant, Client client) {
		super();
		this.description = description;
		this.restaurant = restaurant;
		this.date = LocalDateTime.now();
	}
	
	public Long getOid() {	return oid;}

	public void setOid(Long oid) {	this.oid = oid;}
	
	
	public LocalDateTime getDate() { return date;}
	
	public void setDate(LocalDateTime date) { this.date = date;}
	
	
	public String getDescription() { return description;}
	
	public void setDescription(String description) { this.description = description;}
	
	
	public Restaurant getRestaurant() {	return restaurant;	}
	
	public void setRestaurant(Restaurant restaurant) {	this.restaurant = restaurant;	}

}
