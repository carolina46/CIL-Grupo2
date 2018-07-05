package model.business;
import java.util.ArrayList;
import java.util.List;

import model.vote.DishVote;

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
	private String picture;
	private List<Tag> tags; 
	private List<DishVote> dishVotes;
	
	public Dish() {} //For Hibernate
	
	public Dish(String name, String description, String picture) {
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.tags = new ArrayList<Tag>();
		this.dishVotes = new ArrayList<DishVote>();
	}
	
	
	public Long getOid() { return oid;}

	public void setOid(Long oid) { this.oid = oid;}
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name;}
	
	public String getDescription() { return description;}
	
	public void setDescription(String description) { this.description = description; }
	
	public String getPicture() { return picture; }
	
	public void setPicture(String picture) { this.picture = picture; }

	//Methods associated with list of Tag
	
	public List<Tag> getTags() { return tags;} 
	
	public void addTag(Tag tag) {this.tags.add(tag);}
	
	public void setTags(List<Tag> tags) {this.tags = tags;}
	

	//Methods associated with list of votes
	
	public List<DishVote> getDishVotes() { return dishVotes;}
	
	public void setDishVotes(List<DishVote> dishVotes) { this.dishVotes = dishVotes;}
	
	public void addVote(DishVote dishVote) {this.dishVotes.add(dishVote);}
	
}
