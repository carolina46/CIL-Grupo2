package modelo;

/**
 * Represents the FIRST state of the classification of the users according to the total number of comments made.
 * Next state: Comensal.
 * 
 * @param Receives the user to whom it belongs.
 * 
 * @author Carolina Perez
 */


public class Visitor extends Ranking {

	@Override
	public void updateRanking(User u) {
		if(u.totalOfComments()>19) {
			u.setRanking(new Comensal());
			
		}
	}

}
