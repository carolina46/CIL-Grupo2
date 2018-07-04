package model.users;

import model.business.Location;

public class NormalClient extends Client {

	public NormalClient(String fullName, String user, String password, Location location) {
		super(fullName, user, password, location);
	}

}
