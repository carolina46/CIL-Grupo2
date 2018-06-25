package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Client extends User {

	private Ranking ranking;
	private List<Client> friends;
	private List<Vote> votes;
	private List<Comment> comments;
	private List<Recommendation> recomendations;
	
	public Client(String fullName, String user, String password) {
		super(fullName, user, password);
		this.ranking = new Visitor(); //This is the Initial Ranking
		this.friends = new ArrayList<Client>();
		this.votes = new ArrayList<Vote>();
		this.comments = new ArrayList<Comment>();
		this.recomendations = new ArrayList<Recommendation>();
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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

	public List<Recommendation> getRecomendations() {
		return recomendations;
	}

	public void setRecomendations(List<Recommendation> recomendations) {
		this.recomendations = recomendations;
	}

	public List<Client> getFriends() {
		return friends;
	}

	public void setFriends(List<Client> friends) {
		this.friends = friends;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	
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
