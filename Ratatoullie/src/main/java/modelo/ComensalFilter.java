package modelo;

/**
 * Represents the Comensal configuration for sending notifications to the restaurant manager when there are new comments.
 * Only clients of the Comensal type can comment.
 * Only notifications of clients of type Comensal are sent.
 * @author CIL-Grupo2
 */

public class ComensalFilter extends ConfigurationFilter {
	
	public ComensalFilter(Responsible responsible) {
		super(responsible);
	}

	@Override
	public boolean confirmVisitor() { 
		//This is being called from a Comensal Ranking so it will Deny the permission to comment 
		return false; 
	}

	@Override
	public boolean confirmGourmet() { 
		//This is being called from a Comensal Ranking so it will Deny the permission to comment 
		return false; 
	}

	@Override
	public boolean confirmComensal() { 
		//This is being called from a Comensal Ranking so it will Confirm the permission to comment 
		return true;
	}

	@Override
	public void commentOfVisitor() { /*This is being called from a Comensal Ranking so it will NOT Notify */ }

	@Override
	public void commentOfGourmet() { /*This is being called from a Comensal Ranking so it will NOT Notify */ }

	@Override
	public void commentOfComensal() {this.responsible.notifyNewComments();}

}
