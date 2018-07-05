package model.filter;

/**
 * Represents the DENY configuration. Nobody will be able to comment.
 * @author CIL-Grupo2
 */

public class DenyCommentFilter extends CommentFilter {

	public DenyCommentFilter() {
		super();
	}
	
	@Override
	public boolean confirmVisitorComment() { return false; }

	@Override
	public boolean confirmGourmetComment() { return false; }

	@Override
	public boolean confirmComensalComment() { return false;}

}
