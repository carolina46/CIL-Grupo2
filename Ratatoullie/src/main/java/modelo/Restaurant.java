package modelo;

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
	
	
	public String getName() { return name;}
	public void setName(String name) { this.name = name;}
	
	public Category getCategory() { return category;}
	public void setCategory(Category category) {this.category = category;}

	public void addMenu(Menu m) {
		this.menus.add(m);
	}
}
	