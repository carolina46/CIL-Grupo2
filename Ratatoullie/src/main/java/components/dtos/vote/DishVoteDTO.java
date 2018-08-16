package components.dtos.vote;

import components.dtos.business.DishDTO;

public class DishVoteDTO {
	
	private Long oid;
	private DishDTO dishDTO;
	private Integer value;
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	public DishDTO getDishDTO() {return dishDTO;}
	public void setDishDTO(DishDTO dish) {this.dishDTO = dish;}
	public Integer getValue() {return value;}
	public void setValue(Integer value) {this.value = value;} 
}
