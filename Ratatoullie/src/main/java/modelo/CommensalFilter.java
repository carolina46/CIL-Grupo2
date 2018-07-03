package modelo;

/**
 * Represents the Comensal configuration for sending notifications to the restaurant manager when there are new comments.
 * Only clients of the Comensal type can comment.
 * Only notifications of clients of type Comensal are sent.
 * @author CIL-Grupo2
 */


public class CommensalFilter extends ConfigurationFilter {
	
	public CommensalFilter(Responsible responsible) {
		super();
		this.responsible = responsible;
	}

	@Override
	public boolean confirmVisitor() { return false; }

	@Override
	public boolean confirmGourmet() { return false; }

	@Override
	public boolean confirmComensal() { return true;}

	@Override
	public void commentOfVisitor() {}

	@Override
	public void commentOfGourmet() {}

	@Override
	public void commentOfComensal() {this.responsible.notifyNewComments();}

	
	
	


}
