package components.dtos.filter;

public class CompositeNotificationFilterDTO extends NotificationFilterDTO {

	public CompositeNotificationFilterDTO() {
		name = "Mixed Notifications";
	}
	
	@Override
	public String getName() {
		return name;
	}

}
