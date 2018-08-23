package components.services.interfaces;

import java.util.List;
import model.users.User;

public interface UserService {
	
	public Long saveUser(User user);
	public boolean updateUser(User user);
	public boolean removeUser(User user);
	public boolean removeUserById(Long id);
	public User getUserByID(Long id);
	public User getUserByUser(String user);
	public List<User> getAllUsers();
	public User login(String password, String user);

}

