package components.dtos.filter;

public class VisitorNotificationFilterDTO extends NotificationFilterDTO{

	@Override
	public String getName() {
		name = "Visitor Notifications";
		return name;
	}
}
