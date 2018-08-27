package components.services.interfaces;

import java.util.List;
import model.business.Restaurant;
import model.filter.CommentFilter;
import model.filter.NotificationFilter;

public interface RestaurantService {
	
	public Long saveRestaurant(Restaurant restaurant);
	public boolean updateRestaurant(Restaurant restaurant);
	public boolean removeRestaurant(Restaurant restaurant);
	public boolean removeRestaurantById(Long id);
	public Restaurant getRestuarantByID(Long id);
	public List<Restaurant> getRestaurantByName(String name);
	public List<Restaurant> getAllRestaurants();
	
	public List<CommentFilter> getCommentFilters();
	public List<NotificationFilter> getNotificationFilters();
}
