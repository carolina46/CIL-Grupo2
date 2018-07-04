package model.recommendation;

import java.util.List;

import model.Client;
import model.Restaurant;

/**
 * 
 * This class represents a recommendation about a restaurant
 * 
 * @author CIL-Grupo2
 *
 */

public class RestaurantRecommendation {
	
	private Long oid;
	private Restaurant restaurant;
	private String description;
	private List<Client>	receivers;

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
	
	//Methods associated with Description
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
		
		
	//Methods associated with receivers
	public List<Client> getReceivers() { return receivers;}	
	public void setReceivers(List<Client> receivers) {this.receivers = receivers;}
	public void addReceiver(Client receiver) {this.receivers.add(receiver);}

}
