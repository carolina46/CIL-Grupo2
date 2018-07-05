package model.filter;

/**
 * Represents the configuration for filtering the ability to comment depending on the Client's ranking who made the comment  
 * @author CIL-Grupo2
 */



public abstract class CommentFilter {
	
	private Long oid;//For Hibernate
	
	
	public CommentFilter() {} //For Hibernate
	
	
	public Long getOid() {	return oid;	}
	
	public void setOid(Long oid) { this.oid = oid;}

	
	// They are used to inform if a comment about the restaurant can be made.
	
	public abstract boolean confirmVisitorComment();
	
	public abstract boolean confirmGourmetComment();
	
	public abstract boolean confirmComensalComment();
			
}
