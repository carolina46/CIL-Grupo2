package components.dtos.vote;

import components.dtos.business.MenuDTO;

public class MenuVoteDTO {
	
	private Long oid; 
	private MenuDTO menuDTO;
	private Integer value;
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	public MenuDTO getMenuDTO() {return menuDTO;}
	public void setMenuDTO(MenuDTO menu) {this.menuDTO = menu;}
	public Integer getValue() {return value;}
	public void setValue(Integer value) {this.value = value;} 
}
