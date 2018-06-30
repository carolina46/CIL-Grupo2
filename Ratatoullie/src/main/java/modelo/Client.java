package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Client extends User {

	private Location location;
	private Ranking ranking;
	private List<Client> friends;
	private List<DishVote> dishVotes;
	private List<MenuVote> menuVotes;
	private List<RestaurantVote> restaurantVotes;
	private List<Comment> comments;
	private List<DishRecommendation> dishRecommendations;
	private List<MenuRecommendation> menuRecommendations;
	private List<RestaurantRecommendation> restaurantRecommendations;
	
	
	public Client(String fullName, String user, String password, Location location) {
		super(fullName, user, password);
		this.location = location;
		this.ranking = new Visitor(); //This is the Initial Ranking
		this.friends = new ArrayList<Client>();
		this.comments = new ArrayList<Comment>();
		this.dishVotes = new ArrayList<DishVote>();
		this.menuVotes = new ArrayList<MenuVote>();
		this.restaurantVotes = new ArrayList<RestaurantVote>();
		this.dishRecommendations = new ArrayList<DishRecommendation>();
		this.menuRecommendations = new ArrayList<MenuRecommendation>();
		this.restaurantRecommendations = new ArrayList<RestaurantRecommendation>();
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public int numberOfComments() {
		return comments.size();
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	
	public List<Client> getFriends() {
		return friends;
	}

	public void setFriends(List<Client> friends) {
		this.friends = friends;
	}

	
	public List<DishVote> getDishVotes() { return dishVotes;}

	public void addDishVote(DishVote dishVote) { this.dishVotes.add(dishVote);}

	public List<MenuVote> getMenuVotes() { return menuVotes;}

	public void addMenuVotes(MenuVote menuVote) {this.menuVotes.add(menuVote);}

	public List<RestaurantVote> getRestaurantVotes() { return restaurantVotes;}

	public void addRestaurantVotes(RestaurantVote restaurantVote) {	this.restaurantVotes.add(restaurantVote);}

	public List<DishRecommendation> getDishRecommendations() { return dishRecommendations;}

	public void addDishRecommendations(DishRecommendation dishRecommendation) { this.dishRecommendations.add(dishRecommendation);}

	public List<MenuRecommendation> getMenuRecommendations() { return menuRecommendations;}

	public void addMenuRecommendations(MenuRecommendation menuRecommendation) { this.menuRecommendations.add(menuRecommendation);}

	public List<RestaurantRecommendation> getRestaurantRecommendations() {return restaurantRecommendations;	}

	public void addRestaurantRecommendations(RestaurantRecommendation restaurantRecommendation) { this.restaurantRecommendations.add(restaurantRecommendation);	}

			
	
	public void comment(String comment, Restaurant restaurant) {
		//Creates a comment for a restaurant and adds it to the list of comments
		
		Comment c = new Comment(comment,restaurant);
		this.comments.add(c);
		
		//update my position in the ranking
		this.ranking.updateRanking(this);
	}

	public void deleteComment(String comment, Restaurant restaurant) {
		
		//1- delete an existing comment
		//2- update my position in the ranking
	}
}
