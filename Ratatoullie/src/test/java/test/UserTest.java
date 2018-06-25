package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.Assert;
import modelo.Category;
import modelo.Comensal;
import modelo.Dish;
import modelo.Gourmet;
import modelo.Menu;
import modelo.MenuType;
import modelo.Normal;
import modelo.Responsible;
import modelo.Restaurant;
import modelo.SystemRatatouille;
import modelo.User;
import modelo.Visitor;


class UserTest {
	
	Responsible responsible;
	Normal normal;
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
		restaurant = new Restaurant("Antares", category, "9 entre 39 y 38");
		restaurant.addMenu(menu);
						
		responsible = new Responsible("Juan Mmarcelo", "juan","1234");
		responsible.addRestaurant(restaurant);
		
		normal= new Normal("Titi suarez", "ElTiTi", "titiPass");
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
		Restaurant restaurat_2  =new Restaurant("Grido", new Category("ice cream shop"), "51 entre 8 y 9");
		Responsible responsible_2= new Responsible("Don Grido", "superGrido", "gridoPass");
		responsible.addRestaurant(restaurat_2);
		
		responsible_2.comment("Not bad", restaurant);
		assertTrue(restaurant.numberOfComments() == 0);
						
				
	}
	

}
