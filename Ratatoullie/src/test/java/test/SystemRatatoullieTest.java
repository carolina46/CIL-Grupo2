package test;

import modelo.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SystemRatatoullieTest {
	
	private SystemRatatouille sys;
	private Normal normal_1;
	private Responsible responsible_1;
	private Restaurant restaurant_1;
	private Category category;

	
	
	@BeforeEach
	void setUp() throws Exception {
		sys= SystemRatatouille.getSystemInstance();
		
		//A normal user
		normal_1= new Normal("Pepa", "Pepa001", "1234");
		sys.addUser(normal_1);
		
		//A responsible user
		responsible_1= new Responsible("Colorete", "Colorete01", "passColorete1234");
		sys.addUser(responsible_1);
		
		//A restaurant
		category = new Category("fast Food");
		restaurant_1= new Restaurant("McDonals", category);
		responsible_1.addRestaurant(restaurant_1);
		sys.addRestaurant(restaurant_1);
		
	}
	

	//This test checks if there is a single instance of the system
	@Test
	void systemIsUniqueTest() {
		SystemRatatouille sys2=	SystemRatatouille.getSystemInstance();
		Normal normal_2= new Normal("Marta", "Marta57", "MartaPass");
		
		sys2.addUser(normal_2);
		assertTrue(sys.numberOfUsers() == 3);
		
		sys.deleteRestaurant(restaurant_1);
		assertTrue(sys2.numberOfRestaurants() == 0);
		assertTrue(sys2.numberOfRestaurants() == sys.numberOfRestaurants());
	}
	

	
	//This test checks that the username is unique in the system
	@Test
	void userNameIsUniqueTest() {
		Normal normal_2=new Normal("Marta", "marta001", "1234"); //new username 
		Normal normal_3=new Normal("Petra", "Pepa001", "1234");	//repeated username
		
		sys.addUser(normal_2);
		assertTrue(sys.numberOfUsers() == 3);
		
		sys.addUser(normal_3);
		assertTrue(sys.numberOfUsers() == 3);
	}
	


	@Test
	void commentsContinueExistTest() {
		//agregar comentarios a un restaurante y luego eliminar la persona qe lo hizo
		//comprobar que el comentario aun existe			
	}

	
	
}
