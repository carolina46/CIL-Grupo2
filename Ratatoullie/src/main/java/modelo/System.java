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
	private static System uniqueSystem;
	
	
	//Private constructor, do not allow to generate default constructor.
	private System(List<User> users, List<Restaurant>restaurants) {
		this.users=users;
		this.restaurants=restaurants;
	}
	
	///get a system instance
	public static System getSystemInstance(List<User> users, List<Restaurant>restaurants) {
		if(uniqueSystem==null) {
			uniqueSystem= new System(users, restaurants);
		}
		else {
//			System.out.println("No se puede crear el objeto porque ya existe un objeto de la clase");
		}
		return uniqueSystem;
	}
	
	
	//Override clone method
	@Override
	public System clone(){
	    try {
	        throw new CloneNotSupportedException();
	    } catch (CloneNotSupportedException ex) {
//	        System.out.println("No se puede clonar un objeto de la clase SoyUnico");
	    }
	    return null; 
	}
	
	//Methods associated with Users
	public List<User> getUsers() { return users;}
	public void addUser(User user) {this.users.add(user);}
	public void setUsers(List<User> users) {this.users = users;}
	
	
	//Methods associated with restaurants
	public List<Restaurant> getRestaurant() { return this.restaurants;}
	public void setRestaurant(List<Restaurant> restaurants) {this.restaurants = restaurants;}
	public void addRestaurant(Restaurant restaurant) {this.restaurants.add(restaurant);}

	
}
