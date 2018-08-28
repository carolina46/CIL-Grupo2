package components.dtos.filter;

public class DenyNotificationFilterDTO extends NotificationFilterDTO{

	public DenyNotificationFilterDTO() {

		super();

		name = "Deny Notifications";		
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	
}
