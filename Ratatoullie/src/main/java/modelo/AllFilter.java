package modelo;

import java.util.ArrayList;

public class AllFilter extends CommentFilter {
	
	private ArrayList<CommentFilter> commentFilters = new ArrayList<CommentFilter>();
	
	@Override
	public void agregar(CommentFilter commentFilter)
	{
		commentFilters.add(commentFilter);
	}

	public ArrayList<CommentFilter> getCommentFilters() {
		return commentFilters;
	}

	public void setCommentFilters(ArrayList<CommentFilter> commentFilters) {
		this.commentFilters = commentFilters;
	}

}
