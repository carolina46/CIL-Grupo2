package test;

import modelo.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SystemRatatoullieTest {
	
	private SystemRatatouille sys;
	private Normal normal_1;
	private Responsible responsible1;
	private Restaurant restaurant1;
		

	@BeforeEach
	void setUp() throws Exception {
		sys= SystemRatatouille.getSystemInstance();
		normal_1= new Normal("Pepa", "Pepa001", "1234");
		responsible1= new Responsible("Pepa", "Pepa001", "1234");
		restaurant1= new Restaurant();
		
		
	}
	
	
	@Test
	void userNameIsUniqueTest() {
		Normal normal_2=new Normal("Marta", "marta001", "1234");
		Normal normal_3=new Normal("Pepa", "Pepa001", "1234");
		
		//queremos agregar un usuario nuevo y uno repetido �para verificar trows o mensaje?
		/*
		assertTrows(sys.add(normal_2));
		assertTrows(sys.add(normal_3));
			*/			
	}
	


	@Test
	void commentsContinueExistTest() {
		//agregar comentarios a un restaurante y luego eliminar la persona qe lo hizo
		//comprobar que el comentario aun existe			
	}

	
	
}
