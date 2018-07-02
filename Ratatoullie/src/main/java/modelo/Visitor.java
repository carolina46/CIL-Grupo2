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
		if(c.numberOfComments()>19) {
			c.setRanking(new Comensal());
			
		}
	}

	@Override
	public boolean confirmVisitor() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean confirmGourmet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean confirmCommensal() {
		// TODO Auto-generated method stub
		return false;
	}

}
