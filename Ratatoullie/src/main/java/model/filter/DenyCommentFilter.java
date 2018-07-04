package model.filter;

import model.users.Responsible;

/**
 * Represents the NULL configuration for sending notifications to the restaurant manager when there are new comments.
 * Nobody can comment.
 * No notification is sent 
 * @author CIL-Grupo2
 */

public class DenyCommentFilter extends CommentFilter {

	public DenyCommentFilter(Responsible responsible) {
		super(responsible);
	}
	
	@Override
	public boolean confirmVisitorComment() { return false; }

	@Override
	public boolean confirmGourmetComment() { return false;	}

	@Override
	public boolean confirmComensalComment() { return false;}

	@Override
	public void applyNotificationForVisitor() { }

	@Override
	public void applyNotificationForGourmet() {}

	@Override
	public void applyNotificationForComensal() {}

}
