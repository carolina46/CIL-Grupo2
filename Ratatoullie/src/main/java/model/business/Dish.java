package model.business;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a dish within one or more menus of a restaurant.
 * 
 * @author CIL-Grupo2
 * 
 */

public class Dish {
		
	private Long oid; //For Hibernate
	private String name;
	private String description;
	private byte[] picture;
	private List<Tag> tags; 
	
	public Dish() {} //For Hibernate
	
	public Dish(String name, String description, byte[] picture) {
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.tags = new ArrayList<Tag>();
	}
	
	public Long getOid() { return oid;}

	public void setOid(Long oid) { this.oid = oid;}
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name;}
	
	public String getDescription() { return description;}
	
	public void setDescription(String description) { this.description = description; }
	
	public byte[] getPicture() { return picture; }
	
	public void setPicture(byte[] picture) { this.picture = picture; }

	//Methods associated with list of Tag
	
	public List<Tag> getTags() { return tags;} 
	
	public void addTag(Tag tag) {this.tags.add(tag);}
	
	public void setTags(List<Tag> tags) {this.tags = tags;}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("Dish with oid = "+oid);
	}
	
}
