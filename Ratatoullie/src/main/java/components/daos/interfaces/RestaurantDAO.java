package components.daos.interfaces;

import java.util.List;

import model.business.Restaurant;

public interface RestaurantDAO extends GenericDAO<Restaurant>{

	public List<Restaurant> getRestaurantsByName(String name);
}
