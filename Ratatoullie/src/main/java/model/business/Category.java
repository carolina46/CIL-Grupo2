package model.business;

/**
 * Represents a label that describes the type of food offered by one or more restaurants.
 * @author CIL-Grupo2
 */

public class Category {
	
	private Long oid; //For Hibernate
	private String name;
	
	
	public Category() {} //For Hibernate

	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Long getOid() { return oid;} 

	public void setOid(Long oid) { this.oid = oid;}

	public String getName() { return name;}

	public void setName(String name) { this.name = name;}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("Category with oid = "+oid);
	}
}






