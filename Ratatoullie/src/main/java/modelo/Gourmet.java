package modelo;

/**
 * Represents the THIRD state of the classification of the users according to the total number of comments made.
 * Previous state: Comensal.
 * 
 * @param Receives the user to whom it belongs.
 * 
 * @author Carolina Perez
 */


public class Gourmet extends Ranking {

	@Override
	public void updateRanking(User u) {
		if(u.totalOfComments()<40) {
			u.setRanking(new Comensal());
		}

	}

}
