package components.daos.implementations;

import java.util.List;

import components.daos.HibernateUtil;
import components.daos.interfaces.DishDAO;
import model.business.Dish;

public class DishDAOImpl implements DishDAO {

	private HibernateUtil util;
	
	public DishDAOImpl() {
		super();
	}
	
	@Override
	public Long save(Dish dish) {
		return util.save(dish);
	}

	@Override
	public boolean update(Dish dish) {
		return util.modify(dish);
	}

	@Override
	public boolean remove(Dish dish) {
		return util.delete(dish);
	}

	@Override
	public boolean removeById(Long key) {
		return util.deleteById(key, Dish.class);
	}

	@Override
	public Dish getByID(Long key) {
		return util.getById(key, Dish.class);
	}

	@Override
	public List<Dish> getAll() {
		return util.getAll(Dish.class);
	}

	@Override
	public Dish getDishByNameEqualsTo(String name) {
		//Returns a Dish with a name exactly as the one passed as parameter
		return util.getEntityByTextEquals("name", name, Dish.class);
	}
	
	public List<Dish> getDishesByNameLike(String name){
		//Returns a list of Dishes whose names contains the name passed by parameter
		return util.getEntitiesByTextLike("name", name, Dish.class);
	}

	@Override
	public List<Dish> getDishesWithDescriptionLike(String description) {
		//Returns a list of Dishes whose descriptions contains the description passed by parameter
		return util.getEntitiesByTextLike("description", description, Dish.class);
	}

}
