package model.filter;

import java.util.ArrayList;

import model.users.Responsible;

/**
 * Represents the variant configuration for sending notifications to the restaurant manager when there are new comments.
 * 2 0 3 types of clients can comment.
 * Notifications of 2 0 3 types of clients are sent.
 * @author CIL-Grupo2
 */

public class CompositeFilter extends ConfigurationFilter {
	
	private ArrayList<ConfigurationFilter> configurationFilters;
	
	public CompositeFilter(Responsible responsible) {
		super(responsible);
		configurationFilters = new ArrayList<ConfigurationFilter>();
	}

	public void addFilter(ConfigurationFilter configurationFilter){
		configurationFilters.add(configurationFilter);
	}

	public ArrayList<ConfigurationFilter> getConfigurationFilters() {
		return configurationFilters;
	}

	public void setConfigurationFilters(ArrayList<ConfigurationFilter> configurationFilter) {
		this.configurationFilters = configurationFilter;
	}

	@Override
	public void commentOfVisitor() {
		//It's being called from a Visitor Ranking, it will go through all Configurations but notify only if VisitorConfiguration is present
		for (ConfigurationFilter filter : this.configurationFilters)
			filter.commentOfVisitor();
	}

	@Override
	public void commentOfGourmet() {
		//It's being called from a Gourmet Ranking, it will go through all Configurations but notify only if GourmetConfiguration is present
		for (ConfigurationFilter filter : this.configurationFilters)
			filter.commentOfGourmet();
	}

	@Override
	public void commentOfComensal() {
		//It's being called from a Comensal Ranking, it will go through all Configurations but notify only if ComensalConfiguration is present
		for (ConfigurationFilter filter : this.configurationFilters)
			filter.commentOfComensal();
	}
	
	@Override
	public boolean confirmVisitor() {
		for (ConfigurationFilter filter : this.configurationFilters)
			if(filter.confirmVisitor()) return true;
		return false;
	}

	@Override
	public boolean confirmGourmet() {
		for (ConfigurationFilter filter : this.configurationFilters)
			if(filter.confirmGourmet()) return true;
		return false;
	}

	@Override
	public boolean confirmComensal() {
		for (ConfigurationFilter filter : this.configurationFilters)
			if(filter.confirmComensal()) return true;
		return false;
	}



}
