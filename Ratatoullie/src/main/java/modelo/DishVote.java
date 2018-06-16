package modelo;

/**
 * 
 * This Class represents the vote made to a Dish
 * 
 * @author CIL-Grupo2
 *
 */
public class DishVote extends Vote{
	private Dish dish;

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	
}
