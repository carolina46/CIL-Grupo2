package model.users;


/**
 * Represents a user of the system. This is an abstract class. Actual class will be Administrator, Responsible or Normal.
 * 
 * @author CIL-Grupo2
 */

public abstract class User {
	
	private Long oid;
	private String fullName;
	private String user;
	private String password;
		
	public User(String fullName, String user, String password) {
		this.fullName = fullName;
		this.user = user;
		this.password = password;
	}
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
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
