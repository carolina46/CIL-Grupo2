package model;

/**
 * Represent a label associated with a menu. Describe the grouping of his dishes.
 * @author CIL-Grupo2
 */


public class MenuType {
	
	private Long oid;
	private String name;

	public MenuType(String name) {
		this.name = name;
	}
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public String getNombre() { return name;}
	public void setNombre(String name) { this.name = name;}
}
