package modelo;

/**
 * 
 * This Class represents the vote made to a Restaurant
 * 
 * @author CIL-Grupo2
 *
 */
public class RestaurantVote extends Vote {
	
	private Restaurant restaurant;
		
	public RestaurantVote(Restaurant restaurant, Integer value) {
		super(value);
		this.restaurant = restaurant;
	}

	public Restaurant getRestaurant() {	return restaurant;	}

	public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
	
}
