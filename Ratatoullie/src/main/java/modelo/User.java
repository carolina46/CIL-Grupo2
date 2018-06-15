package modelo;

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

	public int totalOfComments() {
		// COMPLETAR EN BASE A LA COLECCION DE COMENTARIOS QUE VAYAMOS A USAR 
		return 0;
	}

	public void setRanking(Ranking r) {
		this.myRanking=r;
	}
	
	public Ranking getRanking() {
		return this.myRanking;
	}
	
}
