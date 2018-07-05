package model.filter;

import model.Comment;
import model.users.Responsible;

/**
 * Represents the configuration for sending notifications to the restaurant manager when there are new comments 
 * @author CIL-Grupo2
 */

public abstract class NotificationFilter {
	
	private Long oid; //For Hibernate
	protected Responsible responsible;
	
	public NotificationFilter() {} //For Hibernate
	
	public NotificationFilter(Responsible responsible) {
		super();
		this.responsible = responsible;
	}
	
	public Long getOid() { return oid;	}
	
	public void setOid(Long oid) { this.oid = oid;	}
	
	
	public Responsible getResponsible() { return responsible;}
	
	public void setResponsible(Responsible responsible) { this.responsible = responsible;}

	
	//They are used to determine if the restaurant responsible should be notified of a new comment
	 	
	public abstract void applyNotificationForVisitor(Comment coment);
	
	public abstract void applyNotificationForGourmet(Comment coment);
	
	public abstract void applyNotificationForComensal(Comment coment);	
}
