package model.filter;

import java.util.ArrayList;

/**
 * Represents the variant configuration for confirmation of ability to comment depending on Client's ranking.
 * 2 0 3 types of clients can comment.
 * 
 * @author CIL-Grupo2
 */

public class CompositeCommentFilter extends CommentFilter {
	
	private ArrayList<CommentFilter> configurationFilters;
	
	public CompositeCommentFilter() {
		super();
		configurationFilters = new ArrayList<CommentFilter>();
	}

	public void addFilter(CommentFilter configurationFilter){
		configurationFilters.add(configurationFilter);
	}

	public ArrayList<CommentFilter> getConfigurationFilters() {
		return configurationFilters;
	}

	public void setConfigurationFilters(ArrayList<CommentFilter> configurationFilter) {
		this.configurationFilters = configurationFilter;
	}

	@Override
	public boolean confirmVisitorComment() {
		for (CommentFilter filter : this.configurationFilters)
			if(filter.confirmVisitorComment()) return true;
		return false;
	}

	@Override
	public boolean confirmGourmetComment() {
		for (CommentFilter filter : this.configurationFilters)
			if(filter.confirmGourmetComment()) return true;
		return false;
	}

	@Override
	public boolean confirmComensalComment() {
		for (CommentFilter filter : this.configurationFilters)
			if(filter.confirmComensalComment()) return true;
		return false;
	}



}
