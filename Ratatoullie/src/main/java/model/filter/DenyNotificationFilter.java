package model.filter;

import model.users.Responsible;

public class DenyNotificationFilter extends NotificationFilter {

	public DenyNotificationFilter(Responsible responsible) {
		super(responsible);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyNotificationForVisitor() { }

	@Override
	public void applyNotificationForGourmet() {}

	@Override
	public void applyNotificationForComensal() {}

}
