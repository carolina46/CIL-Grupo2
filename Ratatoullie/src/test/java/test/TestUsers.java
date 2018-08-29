package test;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import model.SystemRatatouille;
import model.business.Category;
import model.business.Dish;
import model.business.Location;
import model.business.Menu;
import model.business.MenuType;
import model.business.Restaurant;
import model.users.Responsible;
import model.users.User;

import org.junit.Assert;


class TestUsers {
	

	@Test
	void test() {
		
		//Create a Dish
		Dish dish = new Dish("Milanesas","Milanesas con papas fritas y un mu�equito de regalo",null);
				
		//Createa MenuType
		MenuType mt = new MenuType("Menu infantil");
				
		//Create a Menu of MenuType with the previously created Dish 
		Menu menu = new Menu(mt, "aName");
		menu.addDish(dish);
				
		//Create a Category
		Category category = new Category("Bar-Pub");
				
		//Create a Restaurant of the Category with the previously created Menu
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Antares");
		restaurant.setCategory(category);
		restaurant.addMenu(menu);
				
		Location location = new Location(0d,0d);
		Responsible responsible = new Responsible("Juan Mmarcelo", "juan","1234", location);
		responsible.addRestaurant(restaurant);
				
		ArrayList<User> usersList = (ArrayList<User>) SystemRatatouille.getSystemInstance().getUsers();
		Iterator<User> it = usersList.iterator();
		
		boolean userFound = false;
		while(!userFound && it.hasNext()) {
			User user = it.next();
			if(user.getUser().equals(responsible.getUser())) {
				userFound = true;
			}
		}
		
		if(userFound) { //Nulls it to make it impossible to create
			responsible = null;
		}
		Assert.assertNotNull(responsible);
		
	}

}
