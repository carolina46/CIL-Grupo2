package modelo;

import java.util.ArrayList;

public class AllFilter extends ConfigurationFilter {
	
	private ArrayList<ConfigurationFilter> commentFilters = new ArrayList<ConfigurationFilter>();
	
	@Override
	public void agregar(ConfigurationFilter commentFilter)
	{
		commentFilters.add(commentFilter);
	}

	public ArrayList<ConfigurationFilter> getCommentFilters() {
		return commentFilters;
	}

	public void setCommentFilters(ArrayList<ConfigurationFilter> commentFilters) {
		this.commentFilters = commentFilters;
	}

}
