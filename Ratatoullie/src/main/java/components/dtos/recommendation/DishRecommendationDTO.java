package components.dtos.recommendation;

import java.util.List;
import components.dtos.business.DishDTO;
import components.dtos.users.ClientDTO;

public class DishRecommendationDTO {
	
	private Long oid;//For Hibernate
	private DishDTO dishDTO;
	private String description;
	private List<ClientDTO> receiversDTO;

	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	public DishDTO getDishDTO() {return dishDTO;}
	public void setDishDTO(DishDTO dishDTO) {this.dishDTO = dishDTO;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public List<ClientDTO> getReceiversDTO() {return receiversDTO;}
	public void setReceiversDTO(List<ClientDTO> receiversDTO) {this.receiversDTO = receiversDTO;}
}
