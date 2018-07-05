package model.filter;

import model.users.Responsible;

public class VisitorNotificationFilter extends NotificationFilter {

	public VisitorNotificationFilter(Responsible responsible) {
		super(responsible);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyNotificationForVisitor() { this.responsible.notifyNewComments();}

	@Override
	public void applyNotificationForGourmet() { /*This is being called from a Visitor Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForComensal() { /*This is being called from a Visitor Ranking so it will NOT Notify */ }

}
