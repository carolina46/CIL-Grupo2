package components.dtos.filter;

public class VisitorNotificationFilterDTO extends NotificationFilterDTO{

	public VisitorNotificationFilterDTO() {

		super();

		name = "Visitor Notifications";
	}
	
	@Override
	public String getName() {
		return name;

	}

}
