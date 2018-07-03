package modelo;

/**
 * Represents the Visitor configuration for sending notifications to the restaurant manager when there are new comments.
 * Only clients of the visitor type can comment.
 * Only notifications of clients of type visit are sent.
 * @author CIL-Grupo2
 */


public class VisitorFilter extends ConfigurationFilter {
	
	
	public VisitorFilter(Responsible responsible) {
		super();
		this.responsible = responsible;
	}

	
	@Override
	public boolean confirmVisitor() { return true;}

	@Override
	public boolean confirmGourmet() { return false;	}

	@Override
	public boolean confirmComensal() { return false;}

	
	@Override
	public void commentOfVisitor() { this.responsible.notifyNewComments();}

	@Override
	public void commentOfGourmet() {}

	@Override
	public void commentOfComensal() {}

	
	
}
