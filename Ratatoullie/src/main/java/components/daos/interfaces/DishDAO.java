package components.daos.interfaces;

import java.util.List;

import model.business.Dish;

public interface DishDAO extends GenericDAO<Dish> {
	
	public Dish getDishByName(String name);
	public List<Dish> getDishesByNameLike(String name);
	public List<Dish> getDishesWithDescriptionLike(String description);

}
