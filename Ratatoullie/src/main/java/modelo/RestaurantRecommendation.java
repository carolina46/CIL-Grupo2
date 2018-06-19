package modelo;

import java.util.List;

/**
 * 
 * This class represents a recommendation about a restaurant
 * 
 * @author CIL-Grupo2
 *
 */

public class RestaurantRecommendation extends Recommendation {
	
	private Restaurant restaurant;

	public RestaurantRecommendation(String description, List<User> receivers, Restaurant restaurant) {
		super(description, receivers);
		this.restaurant = restaurant;
	}

	
	public Restaurant getRestaurant() {	return restaurant;}
	public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
	
	

}
