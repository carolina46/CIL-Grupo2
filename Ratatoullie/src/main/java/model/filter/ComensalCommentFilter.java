package model.filter;

/**
 * Represents the COMENSAL configuration for filtering the ability to comment.
 * Only clients of the Comensal type can comment.
 * @author CIL-Grupo2
 */

public class ComensalCommentFilter extends CommentFilter {
	
	public ComensalCommentFilter() {
		super();
	}

	@Override
	public boolean confirmVisitorComment() { 
		//This is being called from a Visitor Ranking so it will Deny the permission to comment 
		return false; 
	}

	@Override
	public boolean confirmGourmetComment() { 
		//This is being called from a Gourmet Ranking so it will Deny the permission to comment 
		return false; 
	}

	@Override
	public boolean confirmComensalComment() { 
		//This is being called from a Comensal Ranking so it will Confirm the permission to comment 
		return true;
	}

}
