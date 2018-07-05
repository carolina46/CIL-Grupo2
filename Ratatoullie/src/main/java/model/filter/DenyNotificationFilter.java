package model.filter;

import model.Comment;
import model.users.Responsible;

/**
 * Represents the DENY configuration. No notification will be sent
 * @author CIL-Grupo2
 */

public class DenyNotificationFilter extends NotificationFilter {
	
	public DenyNotificationFilter() {} //For Hibernate

	public DenyNotificationFilter(Responsible responsible) {
		super(responsible);
	}

	@Override
	public void applyNotificationForVisitor(Comment comment) {}

	@Override
	public void applyNotificationForGourmet(Comment comment) {}

	@Override
	public void applyNotificationForComensal(Comment comment) {}

}
