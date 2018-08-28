package components.dtos.filter;

import components.dtos.users.ResponsibleDTO;

public abstract class NotificationFilterDTO {
	
	private Long oid;
	protected ResponsibleDTO responsible;
	
	public NotificationFilterDTO() {
		super();
	} 
	
	public Long getOid() {
		return oid;
	}


	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public ResponsibleDTO getResponsible() {
		return responsible;
	}
	public void setResponsible(ResponsibleDTO responsible) {
		this.responsible = responsible;
	}
	
	

	String name;
		
	public abstract String getName();
}
