package components.daos;

import model.business.Restaurant;

public interface RestaurantDAO {

	public Restaurant getByName(String name);
}
