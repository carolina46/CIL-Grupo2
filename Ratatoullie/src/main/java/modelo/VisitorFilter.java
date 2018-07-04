package modelo;

/**
 * Represents the Visitor configuration for sending notifications to the restaurant manager when there are new comments.
 * Only clients of the visitor type can comment.
 * Only notifications of clients of type visit are sent.
 * @author CIL-Grupo2
 */

public class VisitorFilter extends ConfigurationFilter {
	
	public VisitorFilter(Responsible responsible) {
		super(responsible);
	}
	
	@Override
	public boolean confirmVisitor() { 
		//This is being called from a Visitor Ranking so it will Confirm the permission to comment 
		return true;
	}

	@Override
	public boolean confirmGourmet() { 
		//This is being called from a Visitor Ranking so it will Deny the permission to comment 
		return false;	
	}

	@Override
	public boolean confirmComensal() { 
		//This is being called from a Visitor Ranking so it will Deny the permission to comment
		return false;
	}
	
	@Override
	public void commentOfVisitor() { this.responsible.notifyNewComments();}

	@Override
	public void commentOfGourmet() { /*This is being called from a Visitor Ranking so it will NOT Notify */ }

	@Override
	public void commentOfComensal() { /*This is being called from a Visitor Ranking so it will NOT Notify */ }

	
	
}
