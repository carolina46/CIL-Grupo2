package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

import org.junit.jupiter.api.Test;

import modelo.Comensal;
import modelo.Gourmet;
import modelo.Normal;

import modelo.Restaurant;


class RakingTest{

	Normal normal;
	Restaurant restaurant;
	
	@Before 
	public void setUp(){
		//System.out.println("init()");
		
		this.normal = new Normal("Juan Dominguez", "juan", "juan1234");
		this.restaurant = new Restaurant();
	}
	
	@Test
	void testFirstRanking() {
		//This Test is for ensuring that passing of the Ranking from Visitor to Comensal its done correctly 
		System.out.println("testFirstRanking()");
		for(int i=1; i<22; i++) {
			normal.comment("comentario"+ i, restaurant);
			System.out.println("Execution number"+ i);
			if(i == 20)
				assertEquals(Comensal.class,normal.getRanking().getClass()); //when comments reach 20 Ranking changes to Comensal
		}
	}
	
	@Test
	void testSecondRanking() {
		//This Test is for ensuring that passing of the Ranking from Comensal to Gourment its done correctly
		System.out.println("testSecondRanking()");
		
		for(int i=22; i<42; i++) {
			normal.comment("comentario"+ i, restaurant);
			System.out.println("Execution number"+ i);
			if(i==40)
				assertEquals(Gourmet.class,normal.getRanking().getClass()); //when comments reach 40 Ranking changes to Gourmet	
		}
	}
	
	/**
	 * 
	 *  THIS TEST WORK FOR ITSELF -- TRYING TO SPLIT INTO TWO TESTS FOR BETTER DETAIL
	 *  
	 *  
	@Test
	void test() {
		//This Test is for ensuring that passing of the Ranking its done correctly
		Normal normal = new Normal("Juan Dominguez", "juan", "juan1234");
		
		Restaurant restaurant = new Restaurant();
		
		for(int i=1; i<22; i++) {
			normal.comment("comentario"+ i, restaurant);
			
			switch(i){
				case 20: assertEquals(Comensal.class,normal.getRanking().getClass());break; //when comments reach 20 Ranking changes to Comensal
				case 40: assertEquals(Gourmet.class,normal.getRanking().getClass());break; //when comments reach 40 Ranking changes to Gourmet
			}	
		}
	}
		*/

	
}

