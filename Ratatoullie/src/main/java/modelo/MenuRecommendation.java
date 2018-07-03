package modelo;

import java.util.List;

/**
 * 
 * This class represents a recommendation about a Menu
 * 
 * @author CIL-Grupo2
 *
 */

public class MenuRecommendation {
	
	private Long oid;
	private Menu menu;
	private String description;
	private List<Client>	receivers;
		
	public MenuRecommendation(String description, List<Client> receivers, Menu menu) {
		super();
		this.menu = menu;
		this.description = description;
		this.receivers = receivers;
	}
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {	this.oid = oid;	}
	
	public Menu getMenu() {return menu;	}
	public void setMenu(Menu menu) {this.menu = menu;}

	//Methods associated with Description
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
		
		
	//Methods associated with receivers
	public List<Client> getReceivers() { return receivers;}	
	public void setReceivers(List<Client> receivers) {this.receivers = receivers;}
	public void addReceiver(Client receiver) {this.receivers.add(receiver);}
	
	

}
