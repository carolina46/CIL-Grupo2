package components.daos.interfaces;

import java.util.List;

import model.business.Menu;
import model.business.Restaurant;

public interface RestaurantDAO extends GenericDAO<Restaurant>{

	public List<Restaurant> getRestaurantsByNameEqualsTo(String name);
	public boolean updateMenu(Menu menu);
}
