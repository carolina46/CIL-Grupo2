package model.users;

import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.business.Dish;
import model.business.Location;
import model.business.Menu;
import model.business.Restaurant;
import model.ranking.Ranking;
import model.ranking.Visitor;
import model.recommendation.DishRecommendation;
import model.recommendation.MenuRecommendation;
import model.recommendation.RestaurantRecommendation;
import model.vote.DishVote;
import model.vote.MenuVote;
import model.vote.RestaurantVote;

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
	
	
	public Client() {} //For Hibernate
		
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
	
	
	public Location getLocation() { return location;}

    public void setLocation(Location location) { this.location = location;}
	

	public Ranking getRanking() { return ranking;}

	public void setRanking(Ranking ranking) { this.ranking = ranking; }

	
	
	//Methods associated with list of Comments
	
	public List<Comment> getComments() { return comments;}

	public int numberOfComments() {	return comments.size();	}

	public boolean canComment(Restaurant restaurant){ return this.ranking.canCommentAbout(restaurant);}
	
	public void comment(String text, Restaurant restaurant) {
		//Comment creation
		Comment comment = new Comment(text,restaurant,this);
		comments.add(comment);
		
		//Ranking Update
		ranking.updateRanking(this);
		
		//Adding Coment to Restaurant
		restaurant.addComment(comment);
		
		//Adding of notfications of the recently created comment
		ranking.notifyNewCommentAbout(restaurant, comment);
	}

	
	/*	IMPLEMET */ public void deleteComment(String comment, Restaurant restaurant) {
							
							//1- delete an existing comment
							//2- update my position in the ranking
						}
						
	
	
	
	//Methods associated with list of Friends
		
	public List<Client> getFriends() { return friends; }

	public void setFriends(List<Client> friends) { this.friends = friends; }

	/*	IMPLEMET */ public void addFriend(Client friend) { 
							//verify that it does not repeat
							this.friends.add(friend);
						}
	
	/*	IMPLEMET */ public void deleteFriend(Client friend) { /*Must delete the client that comes as a parameter*/ }
	
	
	
	
	//Methods associated with list of DishVotes
	
	public List<DishVote> getDishVotes() { return dishVotes;}

	/*	IMPLEMET */ public void addDishVote(DishVote dishVote) { 
						//verify dishVote does not exist
						this.dishVotes.add(dishVote);
					}

	/*	IMPLEMET */ public void updateDishVote(Dish dish, Integer value) {}
	/*	IMPLEMET */ public void deleteDishVote(Dish dish) {}

	
	//Methods associated with list of MenuVotes
	public List<MenuVote> getMenuVotes() { return menuVotes;}

	/*	IMPLEMET */ public void addMenuVotes(MenuVote menuVote) {
							//verify menuVote does not exist
							this.menuVotes.add(menuVote);}
	/*	IMPLEMET */ public void updateMenuVote(Menu menu, Integer value) {}
	/*	IMPLEMET */ public void deleteMenuVote(Menu menu) {}


	
	//Methods associated with list of RestaurantVotes
	public List<RestaurantVote> getRestaurantVotes() { return restaurantVotes;}

	/*	IMPLEMET */ public void addRestaurantVotes(RestaurantVote restaurantVote) {	
							//verify menuVote does not exist
							this.restaurantVotes.add(restaurantVote);}

	/*	IMPLEMET */ public void updateRestaurantVote(Restaurant restaurant, Integer value) {}
	/*IMPLEMET*/ public void deleteRestaurantVote(Restaurant restaurant) {}
	
	
	
	
	//Methods associated with list of DishRecommendations
	public List<DishRecommendation> getDishRecommendations() { return dishRecommendations;}

	/*IMPLEMET
	If there can only be one recommendation on the same element, avoid repetition*/
	public void addDishRecommendations(DishRecommendation dishRecommendation) { this.dishRecommendations.add(dishRecommendation);}

	/*IMPLEMET*/ public void updateDishRecommendationDescription(Dish dish, String description) {}
	/*IMPLEMET*/ public void deleteDishRecommendation(Dish dish) {}
	
	
	//Methods associated with list of MenuRecommendations
	public List<MenuRecommendation> getMenuRecommendations() { return menuRecommendations;}

	/*IMPLEMET
	If there can only be one recommendation on the same element, avoid repetition*/
	public void addMenuRecommendations(MenuRecommendation menuRecommendation) { this.menuRecommendations.add(menuRecommendation);}

	/*IMPLEMET*/ public void updateMenuRecommendationDescription(Menu menu, String description) {}
	/*IMPLEMET*/ public void deleteMenuRecommendation(Menu menu) {}
	
	
	//Methods associated with list of RestaurantRecommendations
	public List<RestaurantRecommendation> getRestaurantRecommendations() {return restaurantRecommendations;	}

	/*IMPLEMET
	If there can only be one recommendation on the same element, avoid repetition*/
	public void addRestaurantRecommendations(RestaurantRecommendation restaurantRecommendation) { this.restaurantRecommendations.add(restaurantRecommendation);	}

	/*IMPLEMET
	allow to modify the friends to whom it is directed*/
	
	/*IMPLEMET*/ public void updateRestaurantRecommendationDescription(Restaurant restaurant, String description) {}
	/*IMPLEMET*/ public void deleteRestaurantRecommendation(Restaurant restaurant) {}
	
}
