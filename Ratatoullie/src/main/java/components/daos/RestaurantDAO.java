package components.daos;

import java.util.List;
import model.business.Restaurant;

public interface RestaurantDAO {

	public void save(Restaurant restaurant);
	
	public List<Restaurant> list();
}
