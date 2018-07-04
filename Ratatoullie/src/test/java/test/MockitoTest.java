package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ranking.Comensal;
import model.ranking.Gourmet;
import model.ranking.Ranking;
import model.ranking.Visitor;
import model.users.NormalClient;

import static org.mockito.Mockito.*; 

class MockitoTest {

	private NormalClient normal;
	private Ranking ranking;
	
	@BeforeEach
	void setUp() throws Exception {
		normal= mock(NormalClient.class);
	}

	
	@Test
	public void VisitorTest()  {
		ranking= new Visitor();
		
		when(normal.numberOfComments()).thenReturn(20);
        ranking.updateRanking(normal);
        verify(normal, times(1)).setRanking(isA(Comensal.class));
    }
	
	@Test
	public void comensalTest()  {
		ranking= new Comensal();
		
		when(normal.numberOfComments()).thenReturn(10);
        ranking.updateRanking(normal);
        verify(normal, times(1)).setRanking(isA(Visitor.class));
        
        when(normal.numberOfComments()).thenReturn(42);
        ranking.updateRanking(normal);
        verify(normal, times(1)).setRanking(isA(Gourmet.class));
        
	}

	@Test
	public void gourmetTest()  {
		ranking= new Gourmet();
		
		when(normal.numberOfComments()).thenReturn(28);
        ranking.updateRanking(normal);
        verify(normal, times(1)).setRanking(isA(Comensal.class));
    }
	
	
	
	
	

}
