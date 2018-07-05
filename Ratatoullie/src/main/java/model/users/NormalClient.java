package model.users;

import model.business.Location;

/**
 * Represents a user of the system can comment on a restaurant and vote or recommend a restaurant, menu or dish.
  * @author CIL-Grupo2
 */

public class NormalClient extends Client {
	
	public NormalClient() {} //For Hibernate

	public NormalClient(String fullName, String user, String password, Location location) {
		super(fullName, user, password, location);
	}

}
