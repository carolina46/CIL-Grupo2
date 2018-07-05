package model.filter;

/**
 * Represents the VISITOR configuration for filtering the ability to comment.
 * Only clients of the Visitor type can comment.
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
		//This is being called from a Gourmet Ranking so it will Deny the permission to comment 
		return false;	
	}

	@Override
	public boolean confirmComensalComment() { 
		//This is being called from a comensal Ranking so it will Deny the permission to comment
		return false;
	}	
	
}
