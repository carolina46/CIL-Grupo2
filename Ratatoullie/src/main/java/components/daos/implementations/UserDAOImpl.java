package components.daos.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import components.daos.HibernateUtil;
import components.daos.interfaces.UserDAO;
import model.users.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private HibernateUtil util;
	
	public UserDAOImpl() {
		super();
	}

	@Override
	public Long save(User user) {
		//Saves a User if the User's name doesn't exist already
		if (util.getEntityByTextEquals("user", user.getUser(), User.class) == null)
			return util.save(user);
		else
			return 0l;
	}

	@Override
	public boolean update(User user) {
		return util.modify(user);
	}

	@Override
	public boolean remove(User user) {
		return util.delete(user);
	}

	@Override
	public boolean removeById(Long key) {
		return util.deleteById(key, User.class);
	}

	@Override
	public User getByID(Long key) {
		return util.getById(key, User.class);
	}

	@Override
	public List<User> getAll() {
		return util.getAllMatchQuery("FROM user WHERE user_type <> " + "'" + "UA" + "';");
	}

	@Override
	public User getUserByNameEqualsTo(String name) {
		return util.getEntityByTextEquals("user", name, User.class);
	}

}
