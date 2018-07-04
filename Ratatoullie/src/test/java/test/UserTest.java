package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.SystemRatatouille;
import model.business.Category;
import model.business.Dish;
import model.business.Location;
import model.business.Menu;
import model.business.MenuType;
import model.business.Restaurant;
import model.ranking.Comensal;
import model.ranking.Gourmet;
import model.ranking.Visitor;
import model.users.NormalClient;
import model.users.Responsible;
import model.users.User;

import org.junit.Assert;


class UserTest {
	
	Responsible responsible;
	NormalClient normal;
	Restaurant restaurant;
	
	@BeforeEach
	void initialize(){
		
		//Create a Dish
		Dish dish = new Dish("Milanesas","Milanesas con papas fritas y un mu�equito de regalo","/resources/01_01_mila.jpg");
						
		//Createa MenuType
		MenuType mt = new MenuType("Menu infantil");
						
		//Create a Menu of MenuType with the previously created Dish 
		Menu menu = new Menu(mt);
		menu.addDish(dish);
						
		//Create a Category
		Category category = new Category("Bar-Pub");

		//Create a Restaurant of the Category with the previously created Menu
		Location restaurantLocation = new Location(0d, 0d);
		restaurant = new Restaurant("Antares", category, restaurantLocation);
		restaurant.addMenu(menu);
					
		Location responsibleLocation = new Location(0d, 0d);
		responsible = new Responsible("Juan Mmarcelo", "juan","1234", responsibleLocation);
		responsible.addRestaurant(restaurant);
		
		Location normalLocation = new Location(0d, 0d);
		normal= new NormalClient("Titi suarez", "ElTiTi", "titiPass", normalLocation);
	}

	@Test
	void test() {	
		
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
	
	
	//verify correct initial Ranking and ranking changes
	@Test
	void checkRankingTest() {	
		
		assertTrue(normal.getRanking() instanceof  Visitor);
		
		
		for(int i=1; i<21;i++)
			normal.comment("MyComment#"+i, restaurant);
		
		assertTrue(normal.getRanking() instanceof  Comensal);
		
		
		normal.deleteComment("MyComment#20", restaurant);
		
		assertTrue(normal.getRanking() instanceof  Visitor);
		
		
		for(int i=20; i<41;i++)
			normal.comment("MyComment#"+i, restaurant);
		
		assertTrue(normal.getRanking() instanceof  Gourmet);
		
		normal.deleteComment("MyComment#40", restaurant);
		
		assertTrue(normal.getRanking() instanceof  Comensal);
		
				
	}
	
	
	//Check the comments of a responsible (no comments are allowed to restaurants less than one km away)
	@Test
	void responsibleCommentTest(){
		Location resutantLocation2 = new Location(0d,0d);
		Restaurant restaurat_2  =new Restaurant("Grido", new Category("ice cream shop"), resutantLocation2);
		Location responsibleLocation2 = new Location(0d,0d);
		Responsible responsible_2= new Responsible("Don Grido", "superGrido", "gridoPass", responsibleLocation2);
		responsible.addRestaurant(restaurat_2);
		
		responsible_2.comment("Not bad", restaurant);
		assertTrue(restaurant.numberOfComments() == 0);
						
				
	}
	

}
