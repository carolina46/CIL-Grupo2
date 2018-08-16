package components.dtos.recommendation;

import java.util.List;
import components.dtos.business.RestaurantDTO;
import components.dtos.users.ClientDTO;


public class RestaurantRecommendationDTO {
	
	private Long oid;
	private RestaurantDTO restaurantDTO;
	private String description;
	private List<ClientDTO> receiversDTO;
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	public RestaurantDTO getRestaurantDTO() {return restaurantDTO;}
	public void setRestaurantDTO(RestaurantDTO restaurantDTO) {this.restaurantDTO = restaurantDTO;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public List<ClientDTO> getReceiversDTO() {return receiversDTO;}
	public void setReceiversDTO(List<ClientDTO> receiversDTO) {this.receiversDTO = receiversDTO;}
}
