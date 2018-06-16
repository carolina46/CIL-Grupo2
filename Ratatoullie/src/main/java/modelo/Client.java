package modelo;

import java.util.List;

public abstract class Client extends User {

	private List<Comment> comments;
	
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

}