package components.dtos.filter;

public class DenyNotificationFilterDTO extends NotificationFilterDTO{

	@Override
	public String getName() {
		name = "Deny Notifications";
		return name;
	}
}
