package components.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import components.daos.interfaces.UserDAO;
import components.services.interfaces.UserService;
import model.business.Restaurant;
import model.users.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	public UserServiceImpl() {}
	
	@Override
	public Long saveUser(User user) {
		return userDAO.save(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.update(user);
	}

	@Override
	public boolean removeUser(User user) {
		return userDAO.remove(user);
	}

	@Override
	public boolean removeUserById(Long id) {
		return userDAO.removeById(id);
	}

	@Override
	public User getUserByID(Long id) {
		return userDAO.getByID(id);
	}

	@Override
	public User getUserByUser(String user) {
		return userDAO.getUserByNameEqualsTo(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAll();
	}

	@Override
	public User login(String password, String user) {
		return userDAO.login(password, user);
	}

	@Override
	public List<Restaurant> getUserRestaurants(Long id) {
		return userDAO.getUserRestaurants(id);
	}

	

}