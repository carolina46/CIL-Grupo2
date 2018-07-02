package modelo;

public class GourmetFilter extends ConfigurationFilter {

	@Override
	public boolean confirm(Client client) {
		
		return client.getRanking().confirmGourmet();
		// TODO Auto-generated method stub
		
	}

	

}
