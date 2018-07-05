package model.filter;

/**
 * Represents the Visitor configuration for sending notifications to the restaurant manager when there are new comments.
 * Only clients of the visitor type can comment.
 * Only notifications of clients of type visit are sent.
 * @author CIL-Grupo2
 */

public class VisitorCommentFilter extends CommentFilter {
	
	public VisitorCommentFilter() {
		super();
	}
	
	@Override
	public boolean confirmVisitorComment() { 
		//This is being called from a Visitor Ranking so it will Confirm the permission to comment 
		return true;
	}

	@Override
	public boolean confirmGourmetComment() { 
		//This is being called from a Visitor Ranking so it will Deny the permission to comment 
		return false;	
	}

	@Override
	public boolean confirmComensalComment() { 
		//This is being called from a Visitor Ranking so it will Deny the permission to comment
		return false;
	}	
	
}
