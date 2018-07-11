package model.business;

import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.filter.CommentFilter;
import model.filter.DenyCommentFilter;
import model.filter.DenyNotificationFilter;
import model.filter.NotificationFilter;

/**
 * Represents an establishment that offers dishes, which are grouped in different menus.
 * @author CIL-Grupo2
 *
 */

public class Restaurant {

	private Long oid; //For Hibernate
	private String name;
	private Category category;
	private List<Menu> menus;
	private Location location;
	private List<Comment> comments;
	private CommentFilter commentFilter;
	private NotificationFilter notificationFilter;

	public Restaurant() {} //For Hibernate 

	public Restaurant(String name, Category category, Location location) {
		super();
		this.name = name;
		this.category = category;
		this.menus = new ArrayList<Menu>();
		this.location = location;
		this.comments = new ArrayList<Comment>();
		this.commentFilter = new DenyCommentFilter();//The First time it will have an DenyCommentFilter which might be changed later
		this.notificationFilter = new DenyNotificationFilter(null);//The First time it will have an DenyNotificationFilter which might be changed later
	}
	
	public Long getOid() {	return oid;	}
	
	public void setOid(Long oid) {	this.oid = oid;	}

	public String getName() { return name;}
	
	public void setName(String name) { this.name = name;}

	public Category getCategory() { return category;}
	
	public void setCategory(Category category) {this.category = category;}

	public Location getLocation() {	return location;}
	
	public void setLocation(Location location) {	this.location = location;}
	
	public CommentFilter getCommentFilter() { return commentFilter;}

	public void setCommentFilter(CommentFilter commentFilter) { this.commentFilter = commentFilter;}

	public NotificationFilter getNotificationFilter() { return notificationFilter;}

	public void setNotificationFilter(NotificationFilter notificationFilter) { this.notificationFilter = notificationFilter;}

	//Methods associated with list of menus
	
	public List<Menu> getMenus() { return this.menus;}
	
	public void setMenus(List<Menu> menus) {this.menus = menus;}
	
	public void addMenu(Menu m) { this.menus.add(m);}

	//Methods associated with list of comments
	
	public List<Comment> getComments() { return comments;}
	
	public void setComments(List<Comment> comments) {	this.comments = comments;}
	
	public void addComment(Comment comment) { this.comments.add(comment);}
	
	public int numberOfComments() { return comments.size();}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("Restaurant with oid = "+oid);
	}
	
		
}
	