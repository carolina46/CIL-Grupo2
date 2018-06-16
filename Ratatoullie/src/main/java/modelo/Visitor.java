package modelo;

/**
 * Represents the FIRST state of the classification of the users according to the total number of comments made.
 * Next state: Comensal.
 * 
 * @author CIL-Grupo2
 */


public class Visitor extends Ranking {

	/**
	 * Change the user's state to comensal depending on the total of comments made.
	 * @param Receives the user whom it belongs.
	 */
	@Override
	public void updateRanking(Client c) {
		if(c.totalOfComments()>19) {
			c.setRanking(new Comensal());
			
		}
	}

}