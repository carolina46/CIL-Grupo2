package components.dtos;

import java.time.LocalDateTime;
import components.dtos.business.RestaurantDTO;

public class CommentDTO {
	
	private Long oid; 
	private String description;
	private LocalDateTime date;
	private RestaurantDTO restaurantDTO;
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	public LocalDateTime getDate() {return date;}
	public void setDate(LocalDateTime date) {this.date = date;}
	
	public RestaurantDTO getRestaurantDTO() {return restaurantDTO;}
	public void setRestaurantDTO(RestaurantDTO restaurantDTO) {this.restaurantDTO = restaurantDTO;}
	
	
}
