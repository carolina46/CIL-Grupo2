package model;

/**
 * Represents a label that describes the type of food offered by one or more restaurants.
 * @author CIL-Grupo2
 */

public class Category {
	
	private Long oid;
	private String name;
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}






