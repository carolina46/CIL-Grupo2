package model.ranking;

import model.Comment;
import model.business.Restaurant;
import model.users.Client;

/**
 * Represents the THIRD state of the classification of the users according to the total number of comments made.
 * Previous state: Comensal.
 * 
* @author CIL-Grupo2
 */


public class Gourmet extends Ranking {

	/**
	 * Change the user's state to comensal depending on the total of comments made.
	 * @param Receives the user whom it belongs.
	 */
	@Override
	public void updateRanking(Client c) {
		if(c.numberOfComments()<40) {
			c.setRanking(new Comensal());
		}

	}

	@Override
	public void notifyNewCommentAbout(Restaurant restaurant, Comment comment) {
		restaurant.getNotificationFilter().applyNotificationForGourmet(comment);
		
	}
	
	@Override
	public boolean canCommentAbout(Restaurant restaurant) {
		return restaurant.getCommentFilter().confirmGourmetComment();
	}

	

}