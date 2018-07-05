package model.business;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a menu of a restaurant. 
 * Group a set of dishes.
 * Can have labels that describe its contents.
 * 
 * @author CIL-Grupo2
 */

public class Menu {
	
	private Long oid; //For Hibernate
	private List<Dish> dishes;
	private List<Tag> tags;
	private MenuType menuType;
	
	public Menu() {} //For Hibernate
	
	public Menu(MenuType menuType) {
		this.dishes = new ArrayList<Dish>();
		this.tags = new ArrayList<Tag>();
		this.menuType = menuType; 
	}
	
	public Long getOid() {return oid;}
	
	public void setOid(Long oid) {	this.oid = oid;}
	
	public MenuType getMenuType() {return menuType;}
	
	public void setMenuType(MenuType menuType) {this.menuType = menuType;}
	
	//Methods associated with list of dishes
	
	public void addDish(Dish dish) {this.dishes.add(dish);}
	
	public List<Dish> getDishes() { return dishes;}
	
	public void setDishes(List<Dish> dishes) {this.dishes = dishes;}
	
	//Methods associated with list of Tags
	
	public void addTag(Tag tag) {this.tags.add(tag);}
	
	public List<Tag> getTags() { return tags;}
	
	public void setTags(List<Tag> tags) {this.tags = tags;}
}
