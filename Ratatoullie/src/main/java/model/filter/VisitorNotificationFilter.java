package model.filter;

import model.Comment;
import model.Notification;
import model.users.Responsible;

/**
 * Represents the VISITOR configuration for sending notifications to the restaurant responsible when there are new comments.
 * Only notifications of clients of type Visitor are sent.
 * @author CIL-Grupo2
 */

public class VisitorNotificationFilter extends NotificationFilter {

	public VisitorNotificationFilter() {super();} //For Hibernate
	
	public VisitorNotificationFilter(Responsible responsible) {
		super(responsible);
	}

	@Override
	public void applyNotificationForVisitor(Comment comment) {
		//Creates notification and adds into Responsible's notification list
		Notification notification = new Notification(comment);
		super.responsible.addNotification(notification);
	}

	@Override
	public void applyNotificationForGourmet(Comment comment) { /*This is being called from a Gourmet Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForComensal(Comment comment) { /*This is being called from a Comensal Ranking so it will NOT Notify */ }

}
