package components.daos.interfaces;

import java.util.List;

import model.business.Restaurant;
import model.users.User;

public interface UserDAO extends GenericDAO<User>{

	public User getUserByNameEqualsTo(String name);
	public User login(String password, String user);
	public List<Restaurant> getUserRestaurants(Long id);
}
