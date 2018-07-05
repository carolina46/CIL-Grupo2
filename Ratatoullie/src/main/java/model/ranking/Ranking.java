package model.ranking;

import model.Comment;
import model.business.Restaurant;
import model.users.Client;

/**
 * Represents the classification of the users according to the total number of comments made.
 * We use the state pattern. In this case it has three possible states: first Visitor, second Comensal and Third Gourmet.
 * 
 * @author CIL-Grupo2
 */

public abstract class Ranking {
	
	/**
	 * Update the Client's state according to the total number of comments made.
	 * @param Receives the user to whom it belongs.
	 */
	
	private Long oid; //For Hibernate
	
	public Ranking() {} //For Hibernate
	
	
	public Long getOid() { return oid;}

	public void setOid(Long oid) { this.oid = oid;}
	
	
	public abstract void updateRanking(Client c);

	
	public abstract void notifyNewCommentAbout(Restaurant restaurant, Comment coment);

	
	public abstract boolean canCommentAbout(Restaurant restaurant);

}
