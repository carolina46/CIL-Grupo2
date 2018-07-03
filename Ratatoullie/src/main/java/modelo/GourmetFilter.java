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
	public boolean confirmVisitor() { return false;}

	@Override
	public boolean confirmGourmet() { return true; }

	@Override
	public boolean confirmComensal() { return false; }

	
	@Override
	public void commentOfVisitor() {}

	@Override
	public void commentOfGourmet() { this.responsible.notifyNewComments();}

	@Override
	public void commentOfComensal() {}

	

}
