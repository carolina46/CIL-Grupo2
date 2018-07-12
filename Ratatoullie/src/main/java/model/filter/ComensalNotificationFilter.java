package model.filter;

import model.Comment;
import model.Notification;
import model.users.Responsible;

/**
 * Represents the COMENSAL configuration for sending notifications to the restaurant manager when there are new comments.
 * Only notifications from the comensal client are sent
 * @author CIL-Grupo2
 */

public class ComensalNotificationFilter extends NotificationFilter {

	public ComensalNotificationFilter() {} //For Hibernate
	
	public ComensalNotificationFilter(Responsible responsible) {
		super(responsible);
	}

	@Override
	public void applyNotificationForVisitor(Comment comment) { /*This is being called from a Visitor Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForGourmet(Comment comment) { /*This is being called from a Gourmet Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForComensal(Comment comment) {
		//Creates notification and adds into Responsible's notification list
		Notification notification = new Notification(comment);
		super.responsible.addNotification(notification);
	}
}
