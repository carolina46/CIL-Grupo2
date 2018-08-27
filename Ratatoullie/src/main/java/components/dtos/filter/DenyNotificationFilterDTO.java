package components.dtos.filter;

public class DenyNotificationFilterDTO extends NotificationFilterDTO{

	public DenyNotificationFilterDTO() {
		name = "Deny Notifications";		
	}
	
	@Override
	public String getName() {
		return name;
	}
}
