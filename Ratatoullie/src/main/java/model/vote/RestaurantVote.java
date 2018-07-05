package model.vote;

import model.business.Restaurant;

/**
 * 
 * This Class represents the vote made to a Restaurant
 * 
 * @author CIL-Grupo2
 *
 */
public class RestaurantVote {
	
	private Long oid; //For Hibernate
	private Restaurant restaurant;
	private Integer value; 
	
	public RestaurantVote() {} //For Hibernate
	
	/* 
	 * possible values = [1..10]
	 * 
	 * It was agreed with the client this will be displayed as 5 Stars in the interface.
	 * This will work in the following way: 
	 * A value of 1 will be Half Star.
	 * A value of 2 will be One Star.
	 * .. and so on, until a value of 10 will be 5 Stars.
	 *  
	 * A value of 0 cannot be assigned, it means there is no vote (0 Stars will not be possible)
	 * */

	public RestaurantVote(Restaurant restaurant, Integer value) {
		super();
		this.restaurant = restaurant;
		this.value=value;
	}
	
	
	public Long getOid() { return oid;}

	public void setOid(Long oid) { this.oid = oid;}

	
	public Restaurant getRestaurant() {	return restaurant;	}

	public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
	
	
	public Integer getValue() {	return value;}

	public void setValue(Integer value) {
		//The Client will not be able to input values outside the range of 1..10. This will be handled in the interface in order this method receive a valid value.
		this.value = value;
	}
	
	
}
