package modelo;

/**
 * Represents the classification of the users according to the total number of comments made.
 * We use the state pattern. In this case it has three possible states: first Visitor, second Comensal and Third Gourmet.
 * 
 * @param Receives the user to whom it belongs.
 * 
 * @author Carolina Perez
 */

public abstract class Ranking {
	
	public abstract void updateRanking(User u);

}
