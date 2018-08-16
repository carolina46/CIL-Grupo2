package components.dtos.recommendation;

import java.util.List;
import components.dtos.business.MenuDTO;
import components.dtos.users.ClientDTO;


public class MenuRecommendationDTO {

	private Long oid; 
	private MenuDTO menuDTO;
	private String description;
	private List<ClientDTO> receiversDTO;
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	public MenuDTO getMenuDTO() {return menuDTO;}
	public void setMenuDTO(MenuDTO menuDTO) {this.menuDTO = menuDTO;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public List<ClientDTO> getReceiversDTO() {return receiversDTO;}
	public void setReceiversDTO(List<ClientDTO> receiversDTO) {this.receiversDTO = receiversDTO;}
		
}
