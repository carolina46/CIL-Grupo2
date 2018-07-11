package model.recommendation;

import java.util.List;

import model.business.Restaurant;
import model.users.Client;

/**
 * 
 * This class represents a recommendation about a restaurant
 * @author CIL-Grupo2
 *
 */

public class RestaurantRecommendation {
	
	private Long oid; //For Hibernate
	private Restaurant restaurant;
	private String description;
	private List<Client> receivers;

	public RestaurantRecommendation() {} //For Hibernate
	
	public RestaurantRecommendation(String description, List<Client> receivers, Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
		this.description = description;
		this.receivers = receivers;
	}
	
	public Long getOid() {	return oid;}
	
	public void setOid(Long oid) {	this.oid = oid;	}
	
	public Restaurant getRestaurant() {	return restaurant;}
	
	public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
	
	public String getDescription() { return description; }
	
	public void setDescription(String description) { this.description = description; }
		
	//Methods associated with list of receivers
	
	public List<Client> getReceivers() { return receivers;}	
	
	public void setReceivers(List<Client> receivers) {this.receivers = receivers;}
	
	public void addReceiver(Client receiver) {this.receivers.add(receiver);}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("RestaurantRecommendation with oid = "+oid);
	}

}
