package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Client extends User {

	private List<Comment> comments;
	private Ranking ranking;
	private List<Recommendation> recomendations;
	private List<Client> friends;
	private List<Vote> votes;
	
	public Client(String fullName, String user, String password) {
		super(fullName, user, password);
		// TODO Auto-generated constructor stub
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int totalOfComments() {
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
		
		Comment c = new Comment();
		LocalDateTime date = LocalDateTime.now();
		c.setDate(date);
		c.setDescription(comment);
		this.getComments().add(c);
		
		//update my position in the ranking
		this.ranking.updateRanking(this);
	}

}
