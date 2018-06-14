package modelo;

public class User {
	
	private String fullName;
	private String user;
	private String password;
	
	public User(String fullName, String user, String password) {
		this.fullName = fullName;
		this.user = user;
		this.password = password;
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
	
}
