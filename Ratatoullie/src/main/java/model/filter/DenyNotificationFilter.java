package model.filter;

import model.Comment;
import model.users.Responsible;

public class DenyNotificationFilter extends NotificationFilter {

	public DenyNotificationFilter(Responsible responsible) {
		super(responsible);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyNotificationForVisitor(Comment comment) { }

	@Override
	public void applyNotificationForGourmet(Comment comment) {}

	@Override
	public void applyNotificationForComensal(Comment comment) {}

}
