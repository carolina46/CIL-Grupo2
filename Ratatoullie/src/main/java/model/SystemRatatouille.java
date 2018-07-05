package model;

import java.util.ArrayList;
import java.util.List;

import model.business.Restaurant;
import model.users.User;

/**
 * Represents the web system Ratatoullie to which you have access to users and restaurants.
 * @author CIL-Grupo2
 *
 */

public class SystemRatatouille {
	
	private Long oid; // For Hibernate
	private List<User> users;
	private	List<Restaurant> restaurants;
	private static SystemRatatouille uniqueSystem;
		
	//Private constructor, do not allow to generate default constructor.
	private SystemRatatouille() {
		super();
		this.users = new ArrayList<User>();
		this.restaurants = new ArrayList<Restaurant>();
	}
	
	///Get a system instance
	public static SystemRatatouille getSystemInstance() {
		if(uniqueSystem==null) {
			uniqueSystem= new SystemRatatouille();
		}
		else {
			System.out.println("Debug: Cannot create. An instance of SystemRatatoullie already exists");
		}
		return uniqueSystem;
	}
	
	
	public Long getOid() { return oid; }

	public void setOid(Long oid) { this.oid = oid; }
	
	
	//Methods associated with list of Users
	
	public List<User> getUsers() { return users;}
	
	public int numberOfUsers() {return this.users.size();}
		
	
			//PENDING IMPLEMENTATION 
			public void setUsers(List<User> users) {
				//for each element must verify that it is unique in the system
				this.users = users;
			}
		
			
			public void addUser(User user) {
				//must verify that it is unique in the system
				this.users.add(user);}
				
			public void deleteUser(User user) {
				
				//Must delete the User passed as a parameter
				
			}

	
	//Methods associated with list of restaurants
	
	public List<Restaurant> getRestaurants() { return this.restaurants;}
	
	public void setRestaurants(List<Restaurant> restaurants) {this.restaurants = restaurants;}
	
	public void addRestaurant(Restaurant restaurant) {this.restaurants.add(restaurant);}
	
	public int numberOfRestaurants() { return this.restaurants.size();}
	
			//PENDING IMPLEMENTATION 
			public void deleteRestaurant(Restaurant restaurant) {
				
				//Must delete the restaurant passed as a parameter 
				
			}

		
}
