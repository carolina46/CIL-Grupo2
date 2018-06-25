package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Comment;
import modelo.Normal;
import modelo.Restaurant;

class RakingTest {

	@Test
	void test() {
		fail("Not yet implemented");
		Normal normal = new Normal("Juan Dominguez", "juan", "juan1234");
		
		Restaurant restaurant = new Restaurant();
		
		for(int i=1; i<42; i++) {
			normal.comment("comentario"+ i, restaurant);
			
			switch(i){
				//case 20: assertEquals();break;
				//case 40: assertTrue();break;
			}
				
		}
	}

}
