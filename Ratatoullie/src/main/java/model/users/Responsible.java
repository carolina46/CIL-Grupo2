package model.users;

import java.util.ArrayList;
import java.util.List;

import model.Location;
import model.Restaurant;

/**
 * Represents a user of the system can comment on a restaurant and vote or recommend a restaurant, menu or dish.
 * And who also is responsible for managing one or more restaurants.
 * 
 * @author CIL-Grupo2
 */

public class Responsible extends Client{
	
	private List<Restaurant> restaurants;

	
	public Responsible(String fullName, String user, String password, Location location) {
		super(fullName, user, password, location);
		this.restaurants = new ArrayList<Restaurant>();
	}
	
	public List<Restaurant> getRestaurants() { return restaurants; }

	public void setRestaurants(List<Restaurant> restaurants) { this.restaurants = restaurants; }

	public void addRestaurant(Restaurant restaurant) { this.restaurants.add(restaurant); }

	public void notifyNewComments() {
		
		//Determine what the notifications will be
	}

}
