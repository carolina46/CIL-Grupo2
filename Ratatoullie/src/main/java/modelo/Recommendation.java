package modelo;

import java.util.List;

/**
 * This is an Abstract Class which represents a user recommendation for one or more users.
 * The subclasses will represent the possible types of recommendations (on a plate, menu or restaurant)
 *  
 * @author CIL-Grupo2
 *
 */

public abstract class Recommendation {
	
	private String description;
	private List<Client>	receivers;
	
	
	public Recommendation(String description, List<Client> receivers) {
		super();
		this.description = description;
		this.receivers = receivers;
	}

		//Methods associated with Description
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	
	//Methods associated with receivers
	public List<Client> getReceivers() { return receivers;}	
	public void setReceivers(List<Client> receivers) {this.receivers = receivers;}
	public void addReceiver(Client receiver) {this.receivers.add(receiver);}

}
