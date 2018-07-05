package model.filter;

import java.util.ArrayList;
import model.users.Responsible;

/** Represents the variant configuration for sending notifications to the restaurant manager when there are new comments.
 * Notifications of 2 0 3 types of clients are sent.
 * 
 * @author CIL-Grupo2
 */


public class CompositeNotificationFilter extends NotificationFilter {

	private ArrayList<NotificationFilter> configurationFilters;
	
	public CompositeNotificationFilter(Responsible responsible) {
		super(responsible);
		configurationFilters = new ArrayList<NotificationFilter>();
	}
	
	public ArrayList<NotificationFilter> getConfigurationFilters() {
		return configurationFilters;
	}

	public void setConfigurationFilters(ArrayList<NotificationFilter> configurationFilters) {
		this.configurationFilters = configurationFilters;
	}

	
	@Override
	public void applyNotificationForVisitor() {
		//It's being called from a Visitor Ranking, it will go through all Configurations but notify only if VisitorConfiguration is present
		for (NotificationFilter filter : this.configurationFilters)
			filter.applyNotificationForVisitor();
	}

	@Override
	public void applyNotificationForGourmet() {
		//It's being called from a Gourmet Ranking, it will go through all Configurations but notify only if GourmetConfiguration is present
		for (NotificationFilter filter : this.configurationFilters)
			filter.applyNotificationForGourmet();
	}

	@Override
	public void applyNotificationForComensal() {
		//It's being called from a Comensal Ranking, it will go through all Configurations but notify only if ComensalConfiguration is present
		for (NotificationFilter filter : this.configurationFilters)
			filter.applyNotificationForComensal();
	}

}
