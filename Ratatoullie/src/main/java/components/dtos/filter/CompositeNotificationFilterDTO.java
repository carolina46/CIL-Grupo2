package components.dtos.filter;

import java.util.ArrayList;


public class CompositeNotificationFilterDTO extends NotificationFilterDTO {


	
	private ArrayList<NotificationFilterDTO> configurationFilters;

	
	

	public ArrayList<NotificationFilterDTO> getConfigurationFilters() {
		return configurationFilters;
	}

	public void setConfigurationFilters(ArrayList<NotificationFilterDTO> configurationFilters) {
		this.configurationFilters = configurationFilters;}

	public CompositeNotificationFilterDTO() {
		name = "Mixed Notifications";
	}
	
	@Override
	public String getName() {
		return name;

	}
	
	

}
