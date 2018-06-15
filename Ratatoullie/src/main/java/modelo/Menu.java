package modelo;
import java.util.List;

/**
 * Represents a menu of a restaurant. 
 * Group a set of dishes.
 * Can have labels that describe its contents.
 * 
 * @author CIL-Grupo2
 */

public class Menu {
	
	private List<Dish> dishes;
	private List<Tag> tags;
	
	public void addDish(Dish dish) {this.dishes.add(dish);}
	public List<Dish> getDishes() { return dishes;}
	public void setDishes(List<Dish> dishes) {this.dishes = dishes;}
	
	public void addTag(Tag tag) {this.tags.add(tag);}
	public List<Tag> getTags() { return tags;}
	public void setTags(List<Tag> tags) {this.tags = tags;}
}
