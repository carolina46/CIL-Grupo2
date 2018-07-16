package components.daos.interfaces;

import model.business.Restaurant;

public interface RestaurantDAO extends GenericDAO<Restaurant>{

	public Restaurant getByName(String name);
}
