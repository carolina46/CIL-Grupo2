package model.filter;

import java.util.ArrayList;

import model.users.Responsible;

/**
 * Represents the variant configuration for sending notifications to the restaurant manager when there are new comments.
 * 2 0 3 types of clients can comment.
 * Notifications of 2 0 3 types of clients are sent.
 * @author CIL-Grupo2
 */

public class CompositeCommentFilter extends CommentFilter {
	
	private ArrayList<CommentFilter> configurationFilters;
	
	public CompositeCommentFilter(Responsible responsible) {
		super(responsible);
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
	public void applyNotificationForVisitor() {
		//It's being called from a Visitor Ranking, it will go through all Configurations but notify only if VisitorConfiguration is present
		for (CommentFilter filter : this.configurationFilters)
			filter.applyNotificationForVisitor();
	}

	@Override
	public void applyNotificationForGourmet() {
		//It's being called from a Gourmet Ranking, it will go through all Configurations but notify only if GourmetConfiguration is present
		for (CommentFilter filter : this.configurationFilters)
			filter.applyNotificationForGourmet();
	}

	@Override
	public void applyNotificationForComensal() {
		//It's being called from a Comensal Ranking, it will go through all Configurations but notify only if ComensalConfiguration is present
		for (CommentFilter filter : this.configurationFilters)
			filter.applyNotificationForComensal();
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
