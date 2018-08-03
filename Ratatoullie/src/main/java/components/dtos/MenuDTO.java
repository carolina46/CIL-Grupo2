package components.dtos;

import java.util.List;

public class MenuDTO {

	private Long oid;
	private String name;
	private List<DishDTO> dtoDishes;
	private List<TagDTO> dtoTags;
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
		return dtoDishes;
	}
	public void setDtoDishes(List<DishDTO> dtoDishes) {
		this.dtoDishes = dtoDishes;
	}
	public List<TagDTO> getDtoTags() {
		return dtoTags;
	}
	public void setDtoTags(List<TagDTO> dtoTags) {
		this.dtoTags = dtoTags;
	}
	public MenuTypeDTO getMenuType() {
		return menuType;
	}
	public void setMenuType(MenuTypeDTO menuType) {
		this.menuType = menuType;
	}
}
