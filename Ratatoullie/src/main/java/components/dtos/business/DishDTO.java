package components.dtos.business;

import java.util.List;

public class DishDTO {
	
	private Long oid;
	private String name;
	private String description;
	private String picture;
	private List<TagDTO> dtoTags; 
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
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
	public List<TagDTO> getDTOTags() {
		return dtoTags;
	}
	public void setDTOTags(List<TagDTO> tags) {
		this.dtoTags = tags;
	}
}
