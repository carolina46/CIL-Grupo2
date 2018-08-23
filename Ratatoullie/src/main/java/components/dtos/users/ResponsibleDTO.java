package components.dtos.users;

import java.util.List;
import components.dtos.NotificationDTO;
import components.dtos.business.RestaurantDTO;

public class ResponsibleDTO extends ClientDTO{
	
	private List<RestaurantDTO> restaurantsDTO;
	private List<NotificationDTO> notificationsDTO;
	
	public List<RestaurantDTO> getRestaurantsDTO() {return restaurantsDTO;}
	public void setRestaurantsDTO(List<RestaurantDTO> restaurantsDTO) {this.restaurantsDTO = restaurantsDTO;}
	
	public List<NotificationDTO> getNotificationsDTO() {return notificationsDTO;}
	public void setNotificationsDTO(List<NotificationDTO> notificationsDTO) {this.notificationsDTO = notificationsDTO;}
}