package modelo;

/**
 * Represents the SECOND state of the classification of the users according to the total number of comments made.
 * Previous state: Visitor.
 * Next state: Gourmet.
 * 
 * @param Receives the user to whom it belongs.
 * 
 * @author Carolina Perez
 */


public class Comensal extends Ranking {

	@Override
	public void updateRanking(User u) {
		if(u.totalOfComments()>39) 
			u.setRanking(new Gourmet());
		else
			if(u.totalOfComments()<20)
				u.setRanking(new Visitor());
	}

}
