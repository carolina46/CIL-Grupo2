package components.dtos.vote;

import components.dtos.business.RestaurantDTO;

public class RestaurantVoteDTO {

	private Long oid;
	private RestaurantDTO restaurantDTO;
	private Integer value;
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	public RestaurantDTO getRestaurantDTO() {return restaurantDTO;}
	public void setRestaurantDTO(RestaurantDTO restaurantDTO) {this.restaurantDTO = restaurantDTO;}
	public Integer getValue() {return value;}
	public void setValue(Integer value) {this.value = value;} 
}
