package modelo;

import java.util.ArrayList;

public class CompositeCF extends ConfigurationFilter {
	
	private ArrayList<ConfigurationFilter> configurationFilters = new ArrayList<ConfigurationFilter>();
	
	public void addFilter(ConfigurationFilter configurationFilter)
	{
		configurationFilters.add(configurationFilter);
	}

	public ArrayList<ConfigurationFilter> getConfigurationFilters() {
		return configurationFilters;
	}

	public void setConfigurationFilters(ArrayList<ConfigurationFilter> configurationFilter) {
		this.configurationFilters = configurationFilter;
	}

}
