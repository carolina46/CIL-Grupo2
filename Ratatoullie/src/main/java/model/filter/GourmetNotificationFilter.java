package model.filter;

import model.users.Responsible;

public class GourmetNotificationFilter extends NotificationFilter {

	public GourmetNotificationFilter(Responsible responsible) {
		super(responsible);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyNotificationForVisitor() { /*This is being called from a Gourmet Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForGourmet() { this.responsible.notifyNewComments();}

	@Override
	public void applyNotificationForComensal() { /*This is being called from a Gourmet Ranking so it will NOT Notify */ }

}
