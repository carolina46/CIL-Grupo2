package components.dtos.business;

import java.util.List;

public class MenuDTO {

	private Long oid;
	private String name;
	private List<DishDTO> dishes;
	private List<TagDTO> tags;
	private MenuTypeDTO menuType;
	
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
	public List<DishDTO> getDtoDishes() {
		return dishes;
	}
	public void setDtoDishes(List<DishDTO> dtoDishes) {
		this.dishes = dtoDishes;
	}
	public List<TagDTO> getDtoTags() {
		return tags;
	}
	public void setDtoTags(List<TagDTO> dtoTags) {
		this.tags = dtoTags;
	}
	public MenuTypeDTO getMenuType() {
		return menuType;
	}
	public void setMenuType(MenuTypeDTO menuType) {
		this.menuType = menuType;
	}
}
