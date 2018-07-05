package model.filter;

/**
 * Represents the Gourmet configuration for sending notifications to the restaurant manager when there are new comments.
 * Only clients of the Gourmet type can comment.
 * Only notifications of clients of type Gourmet are sent.
 * @author CIL-Grupo2
 */

public class GourmetCommentFilter extends CommentFilter {

	public GourmetCommentFilter() {
		super();
	}
	
	@Override
	public boolean confirmVisitorComment() { 
		//This is being called from a Gourmet Ranking so it will Deny the permission to comment 
		return false;
	}

	@Override
	public boolean confirmGourmetComment() { 
		//This is being called from a Gourmet Ranking so it will Confirm the permission to comment
		return true; 
	}

	@Override
	public boolean confirmComensalComment() { 
		//This is being called from a Gourmet Ranking so it will Deny the permission to comment
		return false; 
	}	

}
