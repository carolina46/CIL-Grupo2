package modelo;

/**
 * Represents the SECOND state of the classification of the users according to the total number of comments made.
 * Previous state: Visitor.
 * Next state: Gourmet.
 * 
 * @author CIL-Grupo2
 */


public class Comensal extends Ranking {

	/**
	 * Change the user's state to visitor o gourmet depending on the total of comments made.
	 * @param Receives the user whom it belongs.
	 */
	@Override
	public void updateRanking(User u) {
		if(u.totalOfComments()>39) 
			u.setRanking(new Gourmet());
		else
			if(u.totalOfComments()<20)
				u.setRanking(new Visitor());
	}

}
