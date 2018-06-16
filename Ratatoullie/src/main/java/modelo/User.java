package modelo;


/**
 * Represents a user of the system who can comment on a restaurant and vote or recommend a restaurant, menu or dish.
 * 
 * @author CIL-Grupo2
 */


public class User {
	
	private String fullName;
	private String user;
	private String password;
	private Ranking myRanking;
		
	public User(String fullName, String user, String password) {
		this.fullName = fullName;
		this.user = user;
		this.password = password;
		this.myRanking = new Visitor();
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setRanking(Ranking r) {
		this.myRanking=r;
	}
	
	public Ranking getRanking() {
		return this.myRanking;
	}
	
}
