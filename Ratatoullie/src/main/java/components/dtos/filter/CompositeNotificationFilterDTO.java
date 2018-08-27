package components.dtos.filter;

public class CompositeNotificationFilterDTO extends NotificationFilterDTO {

	@Override
	public String getName() {
		name = "Mixed Notifications";
		return name;
	}

}
