package modelo;

import java.time.LocalDateTime;

/**
 * Represents a comment from a user about a restaurant
 * 
 * @author CIL-Grupo2
 */


public class Comment {

	private String description;
	private LocalDateTime date;
	private Restaurant restaurant;
	
	public Comment(String description, Restaurant restaurant) {
		this.description = description;
		this.restaurant = restaurant;
		date = LocalDateTime.now();
	}
	
	//Methods associated with Date
	public LocalDateTime getDate() {	return date;}
	public void setDate(LocalDateTime date) { this.date = date;}
	
	//Methods associated with Description
	public String getDescription() { return description;}
	public void setDescription(String description) { this.description = description;}
	
	//Methods associated with Restaurant
	public Restaurant getRestaurant() {		return restaurant;	}
	public void setRestaurant(Restaurant restaurant) {	this.restaurant = restaurant;	}
}
