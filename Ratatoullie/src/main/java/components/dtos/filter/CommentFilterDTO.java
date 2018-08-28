package components.dtos.filter;

public abstract class CommentFilterDTO {
	
	
	
	public CommentFilterDTO() {
		super();
		
	}

	private Long oid;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}
	
}
