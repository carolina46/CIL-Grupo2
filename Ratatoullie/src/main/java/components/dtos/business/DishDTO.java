package components.dtos.business;

import java.sql.Blob;
import java.util.List;

public class DishDTO {
	
	private Long oid;
	private String name;
	private String description;
	private Blob picture;
	private List<TagDTO> tags; 
	
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
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public List<TagDTO> getDTOTags() {
		return tags;
	}
	public void setDTOTags(List<TagDTO> tags) {
		this.tags = tags;
	}
}
