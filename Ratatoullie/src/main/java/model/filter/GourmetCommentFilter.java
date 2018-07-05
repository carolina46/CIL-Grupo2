package model.filter;

/**
 * Represents the GOURMET configuration for filtering the ability to comment.
 * Only clients of the Gourmet type can comment.
 * @author CIL-Grupo2
 */

public class GourmetCommentFilter extends CommentFilter {

	public GourmetCommentFilter() {
		super();
	}
	
	@Override
	public boolean confirmVisitorComment() { 
		//This is being called from a Visitor Ranking so it will Deny the permission to comment 
		return false;
	}

	@Override
	public boolean confirmGourmetComment() { 
		//This is being called from a Gourmet Ranking so it will Confirm the permission to comment
		return true; 
	}

	@Override
	public boolean confirmComensalComment() { 
		//This is being called from a Comensal Ranking so it will Deny the permission to comment
		return false; 
	}	

}
