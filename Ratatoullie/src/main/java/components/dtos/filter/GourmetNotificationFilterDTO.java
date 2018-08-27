package components.dtos.filter;

public class GourmetNotificationFilterDTO extends NotificationFilterDTO {

	public GourmetNotificationFilterDTO() {
		name = "Gourmet Notitifications";
	}
	
	@Override
	public String getName() {
		return name;
	}

}
