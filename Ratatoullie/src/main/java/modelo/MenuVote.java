package modelo;

/**
 * 
 * This Class represents the vote made to a Menu
 * 
 * @author CIL-Grupo2
 *
 */
public class MenuVote extends Vote {
	private Dish dish;

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}
}
