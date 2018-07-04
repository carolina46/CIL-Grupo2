package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modelo.Category;
import modelo.CompositeCF;
import modelo.ConfigurationFilter;
import modelo.Dish;
import modelo.GourmetFilter;
import modelo.Location;
import modelo.Menu;
import modelo.MenuType;
import modelo.Normal;
import modelo.Responsible;
import modelo.Restaurant;
import modelo.VisitorFilter;

class ConfigurationFilterTest {

	@BeforeAll
	public static void setUp(){
		System.out.println("init()");
		
		//Create a Dish
		Dish dish = new Dish("Milanesas","Milanesas con papas fritas y un muniequito de regalo","/resources/01_01_mila.jpg");
						
		//Createa MenuType
		MenuType mt = new MenuType("Menu infantil");
						
		//Create a Menu of MenuType with the previously created Dish 
		Menu menu = new Menu(mt);
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
		
		ConfigurationFilter cf = new CompositeCF(responsible);
		
		VisitorFilter vf = new VisitorFilter(responsible);
		GourmetFilter gf = new GourmetFilter(responsible);
		
		
		restaurant.setFilter(vf);
		
		
	}
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
