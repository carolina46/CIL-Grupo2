package components.dtos.filter;

public class ComensalNotificationFilterDTO extends NotificationFilterDTO {

	public ComensalNotificationFilterDTO() {

		super();
		

		name = "Comensal Notifications";
	}
	
	@Override
	public String getName() {
		return name;
	}

}
