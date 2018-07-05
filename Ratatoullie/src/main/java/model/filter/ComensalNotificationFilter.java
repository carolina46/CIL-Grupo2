package model.filter;

import model.users.Responsible;

public class ComensalNotificationFilter extends NotificationFilter {

	public ComensalNotificationFilter(Responsible responsible) {
		super(responsible);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyNotificationForVisitor() { /*This is being called from a Comensal Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForGourmet() { /*This is being called from a Comensal Ranking so it will NOT Notify */ }

	@Override
	public void applyNotificationForComensal() {super.responsible.notifyNewComments();}

}
