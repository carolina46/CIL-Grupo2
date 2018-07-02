package modelo;

public class VisitorFilter extends ConfigurationFilter {

	@Override
	public boolean confirm(Client client) {
		// TODO Auto-generated method stub
		return client.getRanking().confirmVisitor();
	}

	
}
