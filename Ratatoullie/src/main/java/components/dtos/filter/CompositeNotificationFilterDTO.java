package components.dtos.filter;

import java.util.ArrayList;


public class CompositeNotificationFilterDTO extends NotificationFilterDTO {

	
	private ArrayList<NotificationFilterDTO> configurationFilters;

	
	public CompositeNotificationFilterDTO() {
		super();
	}

	public ArrayList<NotificationFilterDTO> getConfigurationFilters() {
		return configurationFilters;
	}

	public void setConfigurationFilters(ArrayList<NotificationFilterDTO> configurationFilters) {
		this.configurationFilters = configurationFilters;
	}
	
	

}
