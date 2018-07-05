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

	
	public void addFilter(CommentFilter configurationFilter){ configurationFilters.add(configurationFilter);}

	public ArrayList<CommentFilter> getConfigurationFilters() {	return configurationFilters;}

	public void setConfigurationFilters(ArrayList<CommentFilter> configurationFilter) {	this.configurationFilters = configurationFilter;}

	
	@Override
	public boolean confirmVisitorComment() {
		//It's being called from a Visitor Ranking, it will go through all Configurations but only allows comment if VisitorConfiguration is present
		for (CommentFilter filter : this.configurationFilters)
			if(filter.confirmVisitorComment()) return true;
		return false;
	}

	@Override
	public boolean confirmGourmetComment() {
		//It's being called from a Gourmet Ranking, it will go through all Configurations but only allows comment if GourmetConfiguration is present
		for (CommentFilter filter : this.configurationFilters)
			if(filter.confirmGourmetComment()) return true;
		return false;
	}

	@Override
	public boolean confirmComensalComment() {
		//It's being called from a Comensal Ranking, it will go through all Configurations but only allows comment if ComensalConfiguration is present
		for (CommentFilter filter : this.configurationFilters)
			if(filter.confirmComensalComment()) return true;
		return false;
	}

}
