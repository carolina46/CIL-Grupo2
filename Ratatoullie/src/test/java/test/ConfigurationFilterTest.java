package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modelo.Category;
import modelo.CompositeCF;
import modelo.Dish;
import modelo.GourmetFilter;
import modelo.Location;
import modelo.Menu;
import modelo.MenuType;
import modelo.NormalClient;
import modelo.Responsible;
import modelo.Restaurant;
import modelo.VisitorFilter;

class ConfigurationFilterTest {

	static Restaurant restaurant;
	static Responsible responsible;
	
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
		restaurant = new Restaurant();
		restaurant.setName("Antares");
		restaurant.setCategory(category);
		restaurant.addMenu(menu);
						
		Location location = new Location(0d,0d);
		responsible = new Responsible("Juan Mmarcelo", "juan","1234", location);
		responsible.addRestaurant(restaurant);
		
	}
	
	
	@Test
	void test() {
		//Creation of a Normal User
		Location location = new Location(1d,1d);
		NormalClient normal = new NormalClient("Juan Ramirez", "juan","1010", location); //This is a Visitor
		
		//Restaurant Configuration
		/**************** ME PARECE MUY RARO ESTE CODIGO
		/ COMPOSITE OBVIAMENTE ASIGNA EL RESPONSABLE.. O SEA PORQUE NO PUEDO INSTANCIAR UN ConfigurationFilter */
		CompositeCF compositeFilter = new CompositeCF(responsible);
		
		/********** PERO LUEGO TENGO QUE VOLVER A ASIGNARLE EL MISMO RESPONSABLE A OTROS FILTROS QUEA SU VEZ ESTAN EN EL COMPOSITE::. QUE RARO:... ES FEO */
		VisitorFilter visitorFilter = new VisitorFilter(responsible);
		GourmetFilter gourmetFilter = new GourmetFilter(responsible);

		compositeFilter.addFilter(visitorFilter);
		compositeFilter.addFilter(gourmetFilter);
		
		restaurant.setFilter(compositeFilter);
		
		//Comment of the user
		//normal.comment("lindo el que lee", restaurant);//this Restaurant allows Visitor and Gourmet to comment.
		
		assertTrue(normal.canComment(restaurant));
	}

}
