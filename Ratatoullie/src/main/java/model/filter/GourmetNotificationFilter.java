package model.filter;

import model.Comment;
import model.Notification;
import model.users.Responsible;

/**
 * Represents the GOURMET configuration for sending notifications to the restaurant responsible when there are new comments.
 * Only notifications of clients of type Gourmet are sent.
 * @author CIL-Grupo2
 */

public class GourmetNotificationFilter extends NotificationFilter {
	
	public GourmetNotificationFilter() {super();} //For Hibernate

	public GourmetNotificationFilter(Responsible responsible) {
		super(responsible);
	}

	@Override
	public void applyNotificationForVisitor(Comment comment) { /*This is being called from a Visitor Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForGourmet(Comment comment) { 
		//Creates notification and adds into Responsible's notification list
		Notification notification = new Notification(comment);
		super.responsible.addNotification(notification);
	}

	@Override
	public void applyNotificationForComensal(Comment comment) { /*This is being called from a Comensal Ranking so it will NOT Notify */ }
}
