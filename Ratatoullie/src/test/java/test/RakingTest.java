package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.business.Location;
import model.business.Restaurant;
import model.ranking.Comensal;
import model.ranking.Gourmet;
import model.users.NormalClient;

class RakingTest{

	static NormalClient normal;
	static Restaurant restaurant;
	
	@BeforeAll 
	public static void setUp(){
		
		Location location = new Location(0d,0d);
		
		normal = new NormalClient("Juan Dominguez", "juan", "juan1234", location);
		restaurant = new Restaurant();
	}
	
	@Test
	void testFirstRanking() {
		//This Test is for ensuring that passing of the Ranking from Visitor to Comensal its done correctly 
		System.out.println("testFirstRanking()");
		for(int i=1; i<21; i++) {
			normal.comment("comentario"+ i, restaurant);
			System.out.println("Execution number"+ i);				
		}
		assertEquals(Comensal.class,normal.getRanking().getClass()); //when comments reach 20 Ranking changes to Comensal
	}
	
	@Test
	void testSecondRanking() {
		//This Test is for ensuring that passing of the Ranking from Comensal to Gourment its done correctly
		System.out.println("testSecondRanking()");
		
		for(int i=22; i<41; i++) {
			normal.comment("comentario"+ i, restaurant);
			System.out.println("Execution number"+ i);	
		}
		assertEquals(Gourmet.class,normal.getRanking().getClass()); //when comments reach 40 Ranking changes to Gourmet	
	}

	
}

