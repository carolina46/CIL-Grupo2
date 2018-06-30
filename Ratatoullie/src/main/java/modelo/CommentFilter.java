package modelo;

public abstract class CommentFilter {
	
	public Restaurant restaurant;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	abstract public void agregar(CommentFilter c);
}
