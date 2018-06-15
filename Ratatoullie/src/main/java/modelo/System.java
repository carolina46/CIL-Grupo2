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
	
	public void addUser(User u) {this.users.add(u);}
	
	public void addRestaurant(Restaurant r) {this.restaurants.add(r);}

}
