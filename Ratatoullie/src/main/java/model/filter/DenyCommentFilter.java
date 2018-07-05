package model.filter;

/**
 * Represents the NULL configuration for sending notifications to the restaurant manager when there are new comments.
 * Nobody can comment.
 * No notification is sent 
 * @author CIL-Grupo2
 */

public class DenyCommentFilter extends CommentFilter {

	public DenyCommentFilter() {
		super();
	}
	
	@Override
	public boolean confirmVisitorComment() { return false; }

	@Override
	public boolean confirmGourmetComment() { return false;	}

	@Override
	public boolean confirmComensalComment() { return false;}

}
