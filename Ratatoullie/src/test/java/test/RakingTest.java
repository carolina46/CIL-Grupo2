package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import modelo.Comensal;
import modelo.Gourmet;
import modelo.Normal;

import modelo.Restaurant;


class RakingTest {

	@Test
	void test() {
		//This Test is for ensuring that passing of the Ranking its done correctly
		Normal normal = new Normal("Juan Dominguez", "juan", "juan1234");
		
		Restaurant restaurant = new Restaurant();
		
		for(int i=1; i<42; i++) {
			normal.comment("comentario"+ i, restaurant);
			
			switch(i){
				case 20: assertEquals(Comensal.class,normal.getRanking().getClass());break; //when comments reach 20 Ranking changes to Comensal
				case 40: assertEquals(Gourmet.class,normal.getRanking().getClass());break; //when comments reach 40 Ranking changes to Gourmet
			}	
		}
	}
	
	
	
	
	
	
	
	
}

