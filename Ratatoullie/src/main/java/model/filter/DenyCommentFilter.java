package model.filter;

import model.users.Responsible;

/**
 * Represents the NULL configuration for sending notifications to the restaurant manager when there are new comments.
 * Nobody can comment.
 * No notification is sent 
 * @author CIL-Grupo2
 */

public class FullDenyFilter extends ConfigurationFilter {

	public FullDenyFilter(Responsible responsible) {
		super(responsible);
	}
	
	@Override
	public boolean confirmVisitor() { return false; }

	@Override
	public boolean confirmGourmet() { return false;	}

	@Override
	public boolean confirmComensal() { return false;}

	@Override
	public void commentOfVisitor() { }

	@Override
	public void commentOfGourmet() {}

	@Override
	public void commentOfComensal() {}

}
