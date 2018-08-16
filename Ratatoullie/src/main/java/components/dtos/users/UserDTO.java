package components.dtos.users;

public abstract class  UserDTO {
	
	private Long oid; 
	private String fullName;
	private String user;
	private String password;
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	public String getFullName() {return fullName;}
	public void setFullName(String fullName) {this.fullName = fullName;}
	public String getUser() {return user;}
	public void setUser(String user) {this.user = user;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
}
