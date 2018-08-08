package components.dtos.business;

import java.util.List;

import components.dtos.LocationDTO;
import components.dtos.filter.CommentFilterDTO;
import components.dtos.filter.NotificationFilterDTO;
import model.Comment;
import model.business.Category;
import model.business.Location;
import model.business.Menu;
import model.filter.CommentFilter;
import model.filter.NotificationFilter;

public class RestaurantDTO {

	private Long oid;
	private String name;
	private Category category;
	private List<MenuDTO> dtoMenus;
	private LocationDTO location;
	private List<CommentDTO> dtosComments;
	private CommentFilterDTO commentFilter;
	private NotificationFilterDTO notificationFilter;
}
