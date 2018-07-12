package model.business;

/**
 * Represents a label that describes the contents of the dish or menu.
 * @author CIL-Grupo2
 */


public class Tag {
	
	private Long oid; //For Hibernate
	private String name;
	
	public Tag() {} //For Hibernate
	
	public Tag(String name) {
		super();
		this.name = name;
	}
	
	public Long getOid() {	return oid;	}
	
	public void setOid(Long oid) {	this.oid = oid;	}
	
	public String getNombre() { return name;}
	
	public void setNombre(String name) {this.name = name;}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("Tag with oid = "+oid);
	}
}
