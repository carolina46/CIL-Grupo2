package modelo;

/**
 * Represents the THIRD state of the classification of the users according to the total number of comments made.
 * Previous state: Comensal.
 * 
 * @author Carolina Perez
 */


public class Gourmet extends Ranking {

	/**
	 * Change the user's state to comensal depending on the total of comments made.
	 * @param Receives the user whom it belongs.
	 */
	@Override
	public void updateRanking(User u) {
		if(u.totalOfComments()<40) {
			u.setRanking(new Comensal());
		}

	}

}
