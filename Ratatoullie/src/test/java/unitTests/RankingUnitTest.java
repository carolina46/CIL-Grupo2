package unitTests;

import org.junit.jupiter.api.Test;

import model.ranking.Comensal;
import model.ranking.Gourmet;
import model.ranking.Ranking;
import model.ranking.Visitor;
import model.users.Client;
import model.users.NormalClient;

//import static org.mockito.Mockito.*; 

/**
 * Unit test of the Ranking class. 
 * Check the correct transition between the different positions of the ranking.
 * 
 * Users can make comments and are ranked according to the total number of them.
 * They can be visitors (less than 20 comments), Comensals (between 20 and 40 comments) and
 * gourmets (more than 40 comments).
 * 
 * @author Carolina Perez
 */


class RankingUnitTest {

//	private Client client= mock(NormalClient.class);
	private Ranking ranking;
	
	/*
	 * Verification of the state visitor.
	 * Check that when the number of comments is:
	 * 		-More than 19, change to the Comensal state.
	 * 		-Less than 20, do not change state
	 */
	
	
	/*
	@Test
	public void VisitorTest()  {
		ranking= new Visitor();
	
		//less than 20 comments. Must not change of state.
		when(client.numberOfComments()).thenReturn(1).thenReturn(19);
		ranking.updateRanking(client);
		ranking.updateRanking(client);
		verify(client, never()).setRanking(isA(Ranking.class));
		
		//More than 19 Comments. Must to change to comensal state.
		when(client.numberOfComments()).thenReturn(20).thenReturn(25);
        ranking.updateRanking(client);
        ranking.updateRanking(client);
        verify(client, times(2)).setRanking(isA(Comensal.class));
    }
	*/
	
	/*
	 * Verification of the state comensal.
	 * Check that when the number of comments is:
	 * 		-More than 40, change to the Gourmet state.
	 * 		-Less than 20, change to the Visitor state.
	 * 		-Between 20 and 40, do not change state
	 */
	
	/*
	@Test
	public void comensalTest()  {
		ranking= new Comensal();
		
		//Between 20 and 40 Comments. Must not change of state.
        when(client.numberOfComments()).thenReturn(20).thenReturn(30).thenReturn(40);
        ranking.updateRanking(client);
        ranking.updateRanking(client);
        ranking.updateRanking(client);
        verify(client, never()).setRanking(isA(Ranking.class));
		
		//Less than 20 Comments. Must to change to Visitor state.
		when(client.numberOfComments()).thenReturn(19).thenReturn(15);
        ranking.updateRanking(client);
        ranking.updateRanking(client);
        verify(client, times(2)).setRanking(isA(Visitor.class));
        
        //More than 40 Comments. Must to change to Gourmet state.
        when(client.numberOfComments()).thenReturn(41).thenReturn(45);
        ranking.updateRanking(client);
        ranking.updateRanking(client);
        verify(client, times(2)).setRanking(isA(Gourmet.class));
        
	}
	
	*/
	
	
	/*
	 * Verification of the state Gourmet.
	 * Check that when the number of comments is:
	 * 		-More than 40, do not change state.
	 * 		-Less than 41, change to the Comensal state.
	 */	
	
	
	/*
	@Test
	public void gourmetTest()  {
		ranking= new Gourmet();
		
		//More than 40 comments. Must not change of state.
        when(client.numberOfComments()).thenReturn(41).thenReturn(45);
        ranking.updateRanking(client);
        ranking.updateRanking(client);
        verify(client, never()).setRanking(isA(Ranking.class));
		
		//Less than 41 comments. Must to change to comensal state.
        when(client.numberOfComments()).thenReturn(28).thenReturn(40);
        ranking.updateRanking(client);
        ranking.updateRanking(client);
        verify(client, times(2)).setRanking(isA(Comensal.class));
    }*/
	
}
