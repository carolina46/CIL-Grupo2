package components.dtos.users;

import java.util.List;
import components.dtos.NotificationDTO;
import components.dtos.business.RestaurantDTO;

public class ResponsibleDTO extends ClientDTO{
	
	private List<RestaurantDTO> restaurants;
	private List<NotificationDTO> notifications;
	
	public List<RestaurantDTO> getRestaurantsDTO() {return restaurants;}
	public void setRestaurantsDTO(List<RestaurantDTO> restaurantsDTO) {this.restaurants = restaurantsDTO;}
	
	public List<NotificationDTO> getNotificationsDTO() {return notifications;}
	public void setNotificationsDTO(List<NotificationDTO> notificationsDTO) {this.notifications = notificationsDTO;}
}