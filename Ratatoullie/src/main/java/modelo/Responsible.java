package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user of the system can comment on a restaurant and vote or recommend a restaurant, menu or dish.
 * And who also is responsible for managing one or more restaurants.
 * 
 * @author CIL-Grupo2
 */

public class Responsible extends Client{
	
	private List<Restaurant> restaurants;

	public Responsible(String fullName, String user, String password) {
		super(fullName, user, password);
		this.restaurants = new ArrayList<Restaurant>();
	}
	
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public void addRestaurant(Restaurant restaurant) { this.restaurants.add(restaurant); }

}
