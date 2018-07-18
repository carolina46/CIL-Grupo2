package components.daos.implementations;


import java.util.List;
import org.springframework.stereotype.Repository;
import components.daos.HibernateUtil;
import components.daos.interfaces.RestaurantDAO;
import model.business.Restaurant;

@Repository
public class RestaurantDAOImpl implements  RestaurantDAO{

	private HibernateUtil util;
	
	public RestaurantDAOImpl() {
		super();
	}

	@Override
	public boolean save(Restaurant restaurant) {
		return util.save(restaurant);
	}
	
	@Override
	public boolean update(Restaurant restaurant) {
		return util.modify(restaurant);
	}

	@Override
	public boolean remove(Restaurant restaurant) {
		return util.delete(restaurant);
	}

	@Override
	public Restaurant getByID(Long key) {
		return util.getById(key, Restaurant.class);
	}

	@Override
	public List<Restaurant> getAll() {
		return util.getAll(Restaurant.class);
	}

	@Override
	public List<Restaurant> getByName(String name) {
		return util.getByText("name", name, Restaurant.class);		
	}

	@Override
	public boolean removeById(Long key) {
		return util.deleteById(key, Restaurant.class);
	}
}
