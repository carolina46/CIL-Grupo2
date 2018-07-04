package modelo;

/**
 * Represents the Gourmet configuration for sending notifications to the restaurant manager when there are new comments.
 * Only clients of the Gourmet type can comment.
 * Only notifications of clients of type Gourmet are sent.
 * @author CIL-Grupo2
 */

public class GourmetFilter extends ConfigurationFilter {

	public GourmetFilter(Responsible responsible) {
		super();
		this.responsible = responsible;
	}
	
	@Override
	public boolean confirmVisitor() { 
		//This is being called from a Gourmet Ranking so it will Deny the permission to comment 
		return false;
	}

	@Override
	public boolean confirmGourmet() { 
		//This is being called from a Gourmet Ranking so it will Confirm the permission to comment
		return true; 
	}

	@Override
	public boolean confirmComensal() { 
		//This is being called from a Gourmet Ranking so it will Deny the permission to comment
		return false; 
	}

	@Override
	public void commentOfVisitor() { /*This is being called from a Gourmet Ranking so it will NOT Notify */ }

	@Override
	public void commentOfGourmet() { this.responsible.notifyNewComments();}

	@Override
	public void commentOfComensal() { /*This is being called from a Gourmet Ranking so it will NOT Notify */ }

	

}
