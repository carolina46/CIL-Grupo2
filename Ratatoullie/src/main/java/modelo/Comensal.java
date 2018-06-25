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
	 * Change the Client state to visitor o gourmet depending on the total of comments made.
	 * @param Receives the user whom it belongs.
	 */
	@Override
	public void updateRanking(Client c) {
		if(c.numberOfComments()>39) 
			c.setRanking(new Gourmet());
		else
			if(c.numberOfComments()<20)
				c.setRanking(new Visitor());
	}

}
