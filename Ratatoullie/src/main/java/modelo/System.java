package modelo;

import java.util.List;

/**
 * Represents the web system Ratatoulli to which you have access to users and restaurants.
 * @author CIL-Grupo2
 *
 */

public class System {
	
	private List<User> users;
	private	List<Restaurant> restaurants;
	
	
	//Methods associated with Users
	public List<User> getUsers() { return users;}
	public void addUser(User user) {this.users.add(user);}
	public void setUsers(List<User> users) {this.users = users;}
	
	
	//Methods associated with restaurants
	public List<Restaurant> getRestaurant() { return this.restaurants;}
	public void setRestaurant(List<Restaurant> restaurants) {this.restaurants = restaurants;}
	public void addRestaurant(Restaurant restaurant) {this.restaurants.add(restaurant);}

	
}
