package model.business;

/**
 * Represent a label associated with a menu. Describe the grouping of his dishes.
 * @author CIL-Grupo2
 */


public class MenuType {
	
	private Long oid; //For Hibernate
	private String name;

	public MenuType() {} //For Hibernate
	
	public MenuType(String name) {
		super();
		this.name = name;
	}
	
	public Long getOid() { return oid;}

	public void setOid(Long oid) { this.oid = oid;}
	
	public String getName() { return name;}
	
	public void setName(String name) { this.name = name;}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("MenuType with oid = "+oid);
	}
}
