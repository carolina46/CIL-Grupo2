package modelo;

import java.util.List;

/**
 * Represents a user of the system can comment on a restaurant and vote or recommend a restaurant, menu or dish.
 * And who also is responsible for managing one or more restaurants.
 * 
 * @author CIL-Grupo2
 */

public class Responsible extends Client{
	
	private List<Recommendation> recommendations;

	public Responsible(String fullName, String user, String password) {
		super(fullName, user, password);
		// TODO Auto-generated constructor stub
	}

	public List<Recommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}

}
