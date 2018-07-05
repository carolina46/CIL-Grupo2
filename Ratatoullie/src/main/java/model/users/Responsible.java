package model.users;

import java.util.ArrayList;
import java.util.List;

import model.Notification;
import model.business.Location;
import model.business.Restaurant;

/**
 * Represents a user of the system can comment on a restaurant and vote or recommend a restaurant, menu or dish.
 * And who also is responsible for managing one or more restaurants.
 * 
 * @author CIL-Grupo2
 */

public class Responsible extends Client{
	
	private List<Restaurant> restaurants;
	private List<Notification> notfications;

	public Responsible(String fullName, String user, String password, Location location) {
		super(fullName, user, password, location);
		restaurants = new ArrayList<Restaurant>();
		notfications = new ArrayList<Notification>();
	}
	
	public List<Restaurant> getRestaurants() { return restaurants; }

	public void setRestaurants(List<Restaurant> restaurants) { this.restaurants = restaurants; }

	public void addRestaurant(Restaurant restaurant) { this.restaurants.add(restaurant); }

	public void notifyNewComments() {
		
		//Determine what the notifications will be
	}

	public List<Notification> getNotfications() {
		return notfications;
	}

	public void setNotfications(List<Notification> notfications) {
		this.notfications = notfications;
	}
	
}
