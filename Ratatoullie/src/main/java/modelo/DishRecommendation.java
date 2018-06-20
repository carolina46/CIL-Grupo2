package modelo;

import java.util.List;

/**
 * 
 * This class represents a recommendation about a dish
 * 
 * @author CIL-Grupo2
 *
 */

public class DishRecommendation extends Recommendation {
	
	private Dish dish;
	

	public DishRecommendation(String description, List<Client> receivers, Dish dish) {
		super(description, receivers);
		this.dish = dish;
	}
	
	
	public Dish getDish() {	return dish;}
	public void setDish(Dish dish) { this.dish = dish;}

}
