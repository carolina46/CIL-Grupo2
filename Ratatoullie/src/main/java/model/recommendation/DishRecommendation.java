package model.recommendation;

import java.util.List;

import model.business.Dish;
import model.users.Client;

/**
 * 
 * This class represents a recommendation about a dish
 * 
 * @author CIL-Grupo2
 *
 */

public class DishRecommendation {
	
	private Long oid;//For Hibernate
	private Dish dish;
	private String description;
	private List<Client> receivers;

	public DishRecommendation() {}//For Hibernate
	
	public DishRecommendation(String description, List<Client> receivers, Dish dish) {
		super();
		this.dish = dish;
		this.description = description;
		this.receivers = receivers;
	}
	
	public Long getOid() {	return oid;}
	
	public void setOid(Long oid) {	this.oid = oid;}
	
	public Dish getDish() {	return dish;}
	
	public void setDish(Dish dish) { this.dish = dish;}
	
	public String getDescription() { return description; }
	
	public void setDescription(String description) { this.description = description; }
			
	//Methods associated with list of receivers
	
	public List<Client> getReceivers() { return receivers;}	
	
	public void setReceivers(List<Client> receivers) {this.receivers = receivers;}
	
	public void addReceiver(Client receiver) {this.receivers.add(receiver);}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("DishRecommendation with oid = "+oid);
	}
}
