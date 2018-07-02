package modelo;

public abstract class ConfigurationFilter {
	
	public Restaurant restaurant;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public abstract boolean confirm(Client client);
}
