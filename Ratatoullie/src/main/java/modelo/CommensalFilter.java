package modelo;

public class CommensalFilter extends ConfigurationFilter {

	@Override
	public boolean confirm(Client client) {
		
		return client.getRanking().confirmCommensal();
		// TODO Auto-generated method stub
		
	}



}
