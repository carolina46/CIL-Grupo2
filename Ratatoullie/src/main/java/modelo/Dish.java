package modelo;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a dish within one or more menus of a restaurant.
 * 
 * @author CIL-Grupo2
 * 
 */

public class Dish {
		
	private String name;
	private String description;
	private String picture;
	private List<Tag> tags; //en monguillot use ArrayList (ver diferencias y borrar este comentario)
	private List<DishVote> dishVotes;
	
	public Dish(String name, String description, String picture) {
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.tags = new ArrayList<Tag>();
		this.dishVotes = new ArrayList<DishVote>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	//Methods associated with Tag
	public List<Tag> getTags() { return tags;}
	public void addTag(Tag tag) {this.tags.add(tag);}
	public void setTags(List<Tag> tags) {this.tags = tags;}
	
	
	public List<DishVote> getDishVotes() {
		return dishVotes;
	}
	public void setDishVotes(List<DishVote> dishVotes) {
		this.dishVotes = dishVotes;
	}
	
}
