package test;

import modelo.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SystemRatatoullieTest {
	
	private SystemRatatouille sys;
	private NormalClient normal_1;
	private Responsible responsible_1;
	private Restaurant restaurant_1;
	private Category category;

	
	
	@BeforeEach
	void setUp() throws Exception {
		sys= SystemRatatouille.getSystemInstance();
		
		Location locationNormal = new Location(0d,0d);
		Location locationResponsible = new Location(100d,100d);
		Location locationRestaurant = new Location(500d,500d);
		
		//A normal user
		normal_1= new NormalClient("Pepa", "Pepa001", "1234", locationNormal);
		sys.addUser(normal_1);
		
		//A responsible user
		responsible_1= new Responsible("Colorete", "Colorete01", "passColorete1234", locationResponsible);
		sys.addUser(responsible_1);
		
		//A restaurant
		category = new Category("fast Food");
		restaurant_1= new Restaurant("McDonals", category, locationRestaurant);
		responsible_1.addRestaurant(restaurant_1);
		sys.addRestaurant(restaurant_1);
		
	}
	

	//This test checks if there is a single instance of the system
	@Test
	void systemIsUniqueTest() {
		SystemRatatouille sys2=	SystemRatatouille.getSystemInstance();
		
		Location locationNormal2 = new Location(0d,0d);
		NormalClient normal_2= new NormalClient("Marta", "Marta57", "MartaPass", locationNormal2);
		
		sys2.addUser(normal_2);
		assertTrue(sys.numberOfUsers() == 3);
		
		sys.deleteRestaurant(restaurant_1);
		assertTrue(sys2.numberOfRestaurants() == 0);
		assertTrue(sys2.numberOfRestaurants() == sys.numberOfRestaurants());
	}
	

	
	//This test checks that the username is unique in the system
	@Test
	void userNameIsUniqueTest() {
		Location locationNormal2 = new Location(0d,0d);
		NormalClient normal_2=new NormalClient("Marta", "marta001", "1234", locationNormal2); //new username
		Location locationNormal3 = new Location(0d,0d);
		NormalClient normal_3=new NormalClient("Petra", "Pepa001", "1234", locationNormal3);	//repeated username
		
		sys.addUser(normal_2);
		assertTrue(sys.numberOfUsers() == 3);
		
		sys.addUser(normal_3);
		assertTrue(sys.numberOfUsers() == 3);
	}
	


	//this test checks that a comment continues to exist even if the user who created it has been eliminated
	//DeleteUserTest
	@Test
	void commentContinueExistTest() {
		normal_1.comment("good restaurant", restaurant_1);
		assertTrue(restaurant_1.numberOfComments() == 1);
		
		sys.deleteUser(normal_1);
		assertTrue(restaurant_1.numberOfComments() == 1);
	}
	
	
	//this test checks that a comment no longer exists when their restaurant is deleted
	//DeleteRestaurantTest
		@Test
		void commentNotExistTest() {
			normal_1.comment("The food is horrible", restaurant_1);
			assertTrue(normal_1.numberOfComments() == 1);
			
			sys.deleteRestaurant(restaurant_1);
			assertTrue(normal_1.numberOfComments() == 0);
		}
	
	
	
}
