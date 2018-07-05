package model.filter;

import model.Comment;
import model.Notification;
import model.users.Responsible;

public class GourmetNotificationFilter extends NotificationFilter {

	public GourmetNotificationFilter(Responsible responsible) {
		super(responsible);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyNotificationForVisitor(Comment comment) { /*This is being called from a Gourmet Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForGourmet(Comment comment) { 
		//Creates notfication and adds into Responsible's notification list
		Notification notification = new Notification();
		notification.setComment(comment);
		super.responsible.addNotification(notification);
	}

	@Override
	public void applyNotificationForComensal(Comment comment) { /*This is being called from a Gourmet Ranking so it will NOT Notify */ }

}
