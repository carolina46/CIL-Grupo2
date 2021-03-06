package components.dtos.business;

import java.util.List;
import components.dtos.CommentDTO;
import components.dtos.filter.CommentFilterDTO;
import components.dtos.filter.NotificationFilterDTO;
import components.dtos.business.CategoryDTO;

public class RestaurantDTO {

	private Long oid;
	private String name;
	private CategoryDTO category;
	private List<MenuDTO> menus;
	private LocationDTO location;
	private List<CommentDTO> comments;
	private CommentFilterDTO commentFilter;
	private NotificationFilterDTO notificationFilter;
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public List<MenuDTO> getDtoMenus() {
		return menus;
	}
	public void setDtoMenus(List<MenuDTO> dtoMenus) {
		this.menus = dtoMenus;
	}
	public LocationDTO getLocation() {
		return location;
	}
	public void setLocation(LocationDTO location) {
		this.location = location;
	}
	public List<CommentDTO> getDtosComments() {
		return comments;
	}
	public void setDtosComments(List<CommentDTO> dtosComments) {
		this.comments = dtosComments;
	}
	public CommentFilterDTO getCommentFilter() {
		return commentFilter;
	}
	public void setCommentFilter(CommentFilterDTO commentFilter) {
		this.commentFilter = commentFilter;
	}
	public NotificationFilterDTO getNotificationFilter() {
		return notificationFilter;
	}
	public void setNotificationFilter(NotificationFilterDTO notificationFilter) {
		this.notificationFilter = notificationFilter;
	}
}
