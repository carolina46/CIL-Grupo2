package components.dtos.users;

import model.users.Client;
import model.users.User;

/*
 *This class is used to pass the user's key information to the Frontend.
 */

public class UserSessionDTO {

	private Long oid; 
	private String user;
	private String rol; //Administrator or NormalClient or Responsible
	private String ranking;
	
	public UserSessionDTO(User user){
		this.oid = user.getOid();
		this.user = user.getUser();
		this.rol = user.getClass().getSimpleName();
		if(!rol.equals("Administrator")) {
			Client client = (Client) user;
			this.ranking = client.getRanking().getClass().getSimpleName();
		}
	}

	public Long getOid() { return oid; }
	public String getUser() { return user; }
	public String getRol() { return rol; }
	public String getRanking() { return ranking;}
}
