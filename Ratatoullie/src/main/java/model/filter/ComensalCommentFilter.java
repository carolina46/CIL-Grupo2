package model.filter;

import model.users.Responsible;

/**
 * Represents the Comensal configuration for sending notifications to the restaurant manager when there are new comments.
 * Only clients of the Comensal type can comment.
 * Only notifications of clients of type Comensal are sent.
 * @author CIL-Grupo2
 */

public class ComensalCommentFilter extends CommentFilter {
	
	public ComensalCommentFilter(Responsible responsible) {
		super(responsible);
	}

	@Override
	public boolean confirmVisitorComment() { 
		//This is being called from a Comensal Ranking so it will Deny the permission to comment 
		return false; 
	}

	@Override
	public boolean confirmGourmetComment() { 
		//This is being called from a Comensal Ranking so it will Deny the permission to comment 
		return false; 
	}

	@Override
	public boolean confirmComensalComment() { 
		//This is being called from a Comensal Ranking so it will Confirm the permission to comment 
		return true;
	}

	@Override
	public void applyNotificationForVisitor() { /*This is being called from a Comensal Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForGourmet() { /*This is being called from a Comensal Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForComensal() {this.responsible.notifyNewComments();}

}
