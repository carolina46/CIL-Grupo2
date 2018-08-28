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
	private List<Notification> notifications;
	
	public Responsible() {} //For Hibernate 

	public Responsible(String fullName, String user, String password, Location location) {
		super(fullName, user, password, location);
		restaurants = new ArrayList<Restaurant>();
		notifications = new ArrayList<Notification>();
	}
	
	
	/*IMPLEMENT*/
	@Override
	public void comment(String text, Restaurant restaurant) {
		if(true) { //Control the distance between restaurants
			super.comment(text, restaurant);	
		}
		
	}
	
	
	//Methods associated with list of Restaurants
	
	public List<Restaurant> getRestaurants() { return restaurants; }

	public void setRestaurants(List<Restaurant> restaurants) { this.restaurants = restaurants; }

	/*IMPLEMENT check restaurant repetition*/ public void addRestaurant(Restaurant restaurant) { this.restaurants.add(restaurant); }

	/*IMPLEMENT if can*/ public void deleteRestaurant(Restaurant restaurant) { }
	
	
	//Methods associated with list of notifications
	
	public List<Notification> getNotifications() { return notifications;}

	public void setNotifications(List<Notification> notifications) { this.notifications = notifications; }
	
	public void addNotification(Notification notification) { this.notifications.add(notification);}
	
	/*IMPLEMENT if can*/ public void deleteNotification(Notification notification) { }
}
