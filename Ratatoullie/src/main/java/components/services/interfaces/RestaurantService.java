package components.services.interfaces;

import java.util.List;
import model.business.Restaurant;

public interface RestaurantService {
	
	public boolean saveRestaurant(Restaurant restaurant);
	public boolean updateRestaurant(Restaurant restaurant);
	public boolean removeRestaurant(Restaurant restaurant);
	public boolean removeRestaurantById(Long id);
	public Restaurant getRestuarantByID(Long id);
	public List<Restaurant> getRestaurantByName(String name);
	public List<Restaurant> getAllRestaurants();
}
