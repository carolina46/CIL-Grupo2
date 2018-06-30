package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an establishment that offers dishes, which are grouped in different menus.
 * @author CIL-Grupo2
 *
 */

public class Restaurant {
	
	private String name;
	private Category category;
	private List<Menu> menus;
	private Location location;
	private List<Comment> comments;

	public Restaurant(String name, Category category, Location location) {
		super();
		this.name = name;
		this.category = category;
		this.menus = new ArrayList<Menu>();
		this.location = location;
	}

	public Restaurant() {
		this.menus = new ArrayList<Menu>();
	}
		
	//Methods associated with name
	public String getName() { return name;}
	public void setName(String name) { this.name = name;}
	
	//Methods associated with category
	public Category getCategory() { return category;}
	public void setCategory(Category category) {this.category = category;}

	//Methods associated with menus
	public List<Menu> getMenus() { return this.menus;}
	public void setMenus(List<Menu> menus) {this.menus = menus;}
	public void addMenu(Menu m) { this.menus.add(m);}

	public Location getLocation() {	return location;}
	public void setLocation(Location location) {	this.location = location;}
	

	public List<Comment> getComments() { return comments;}
	public void setComments(List<Comment> comments) {	this.comments = comments;}
	
	public int numberOfComments() {
		return comments.size();
	}
}
	