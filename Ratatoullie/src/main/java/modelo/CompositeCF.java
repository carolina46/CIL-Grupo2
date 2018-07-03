package modelo;

import java.util.ArrayList;

/**
 * Represents the variant configuration for sending notifications to the restaurant manager when there are new comments.
 * 2 0 3 types of clients can comment.
 * Notifications of 2 0 3 types of clients are sent.
 * @author CIL-Grupo2
 */




public class CompositeCF extends ConfigurationFilter {
	
	
	private ArrayList<ConfigurationFilter> configurationFilters = new ArrayList<ConfigurationFilter>();
	
	
	public CompositeCF(ArrayList<ConfigurationFilter> configurationFilters, Responsible responsible) {
		super();
		this.responsible = responsible;
		this.configurationFilters = configurationFilters;
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
		for (ConfigurationFilter filter : this.configurationFilters)
			filter.commentOfVisitor();
	}

	@Override
	public void commentOfGourmet() {
		for (ConfigurationFilter filter : this.configurationFilters)
			filter.commentOfGourmet();
	}

	@Override
	public void commentOfComensal() {
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
