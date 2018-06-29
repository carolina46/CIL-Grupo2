package modelo;

import java.util.List;

/**
 * 
 * This class represents a recommendation about a dish
 * 
 * @author CIL-Grupo2
 *
 */

public class DishRecommendation {
	
	private Dish dish;
	private String description;
	private List<Client>	receivers;
	

	public DishRecommendation(String description, List<Client> receivers, Dish dish) {
		super();
		this.dish = dish;
		this.description = description;
		this.receivers = receivers;
	}
	
	public Dish getDish() {	return dish;}
	public void setDish(Dish dish) { this.dish = dish;}
	
	//Methods associated with Description
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
		
		
	//Methods associated with receivers
	public List<Client> getReceivers() { return receivers;}	
	public void setReceivers(List<Client> receivers) {this.receivers = receivers;}
	public void addReceiver(Client receiver) {this.receivers.add(receiver);}

}
