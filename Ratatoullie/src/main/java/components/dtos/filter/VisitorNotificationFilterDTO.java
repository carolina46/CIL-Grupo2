package components.dtos.filter;

public class VisitorNotificationFilterDTO extends NotificationFilterDTO{

	public VisitorNotificationFilterDTO() {
		name = "Visitor Notifications";
	}
	
	@Override
	public String getName() {
		return name;
	}
}
