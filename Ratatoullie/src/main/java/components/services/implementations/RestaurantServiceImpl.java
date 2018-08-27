package components.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import components.daos.interfaces.RestaurantDAO;
import components.services.interfaces.RestaurantService;
import model.business.Restaurant;
import model.filter.ComensalCommentFilter;
import model.filter.ComensalNotificationFilter;
import model.filter.CommentFilter;
import model.filter.DenyCommentFilter;
import model.filter.DenyNotificationFilter;
import model.filter.GourmetCommentFilter;
import model.filter.GourmetNotificationFilter;
import model.filter.NotificationFilter;
import model.filter.VisitorCommentFilter;
import model.filter.VisitorNotificationFilter;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;
	
	public RestaurantServiceImpl() {}
	
	@Override
	public Long saveRestaurant(Restaurant restaurant) {
		return restaurantDAO.save(restaurant);
	}

	@Override
	public boolean updateRestaurant(Restaurant restaurant) {
		return restaurantDAO.update(restaurant);
	}

	@Override
	public boolean removeRestaurant(Restaurant restaurant) {
		return restaurantDAO.remove(restaurant);
	}

	@Override
	public boolean removeRestaurantById(Long id) {
		return restaurantDAO.removeById(id);
	}

	@Override
	public Restaurant getRestuarantByID(Long id) {
		return restaurantDAO.getByID(id);
	}

	@Override
	public List<Restaurant> getRestaurantByName(String name) {
		return restaurantDAO.getRestaurantsByNameEqualsTo(name);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantDAO.getAll();
	}

	@Override
	public List<CommentFilter> getCommentFilters() {
		//I just need a list of CommentFilter classes => no need to access to DB and therefore it won't use a DAO)
		ArrayList<CommentFilter> filters = new ArrayList<CommentFilter>();
		DenyCommentFilter f1 = new DenyCommentFilter();
		VisitorCommentFilter f2 = new VisitorCommentFilter();
		ComensalCommentFilter f3 = new ComensalCommentFilter();
		GourmetCommentFilter f4 = new GourmetCommentFilter();
		filters.add(f1);
		filters.add(f2);
		filters.add(f3);
		filters.add(f4);
		
		return filters;
	}

	@Override
	public List<NotificationFilter> getNotificationFilters() {
		//I just need a list of NotificationFilter classes => no need to access to DB and therefore it won't use a DAO)
		ArrayList<NotificationFilter> filters = new ArrayList<NotificationFilter>();
		DenyNotificationFilter f1 = new DenyNotificationFilter();
		VisitorNotificationFilter f2 = new VisitorNotificationFilter();
		ComensalNotificationFilter f3 = new ComensalNotificationFilter();
		GourmetNotificationFilter f4 = new GourmetNotificationFilter();
		filters.add(f1);
		filters.add(f2);
		filters.add(f3);
		filters.add(f4);
				
		return filters;
	}

}
