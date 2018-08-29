package components.dtos.business;

import java.util.List;

import model.business.Tag;

public class NewMenuDTO {
	
	private Long restaurant;
	private String name;
	private List<Tag> tags;
	private Long type;
	
	public NewMenuDTO() {super();}
	
	public Long getRestaurant() {return restaurant;	}
	public void setRestaurant(Long restaurant) {this.restaurant = restaurant;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public List<Tag> getTags() {return tags;}
	public void setTags(List<Tag> tags) {this.tags = tags;}
	
	public Long getType() {	return type;}
	public void setType(Long type) {this.type = type;}
	
}
