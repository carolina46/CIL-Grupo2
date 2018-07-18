package components.services.implementations;

import java.util.List;
import org.springframework.stereotype.Service;
import components.daos.interfaces.RestaurantDAO;
import components.services.interfaces.RestaurantService;
import model.business.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantDAO restaurantDAO;
	
	public RestaurantServiceImpl() {}
	
	@Override
	public boolean saveRestaurant(Restaurant restaurant) {
		return restaurantDAO.save(restaurant);
	}

	@Override
	public boolean updateRestaurant(Restaurant restaurant) {
		return restaurantDAO.update(restaurant);
	}

	@Override
	public boolean removeRestaurant(Restaurant restaurant) {
		return restaurantDAO.remove(restaurant);
	}

	@Override
	public boolean removeRestaurantById(Long id) {
		return restaurantDAO.removeById(id);
	}

	@Override
	public Restaurant getRestuarantByID(Long id) {
		return restaurantDAO.getByID(id);
	}

	@Override
	public List<Restaurant> getRestaurantByName(String name) {
		return restaurantDAO.getByName(name);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantDAO.getAll();
	}

}
