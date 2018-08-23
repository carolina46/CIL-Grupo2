package components.daos.interfaces;

import model.users.User;

public interface UserDAO extends GenericDAO<User>{

	public User getUserByNameEqualsTo(String name);
	public User login(String password, String user);
}
