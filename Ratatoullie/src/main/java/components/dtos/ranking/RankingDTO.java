package components.dtos.ranking;

public abstract class RankingDTO {

	private Long oid;

	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	public abstract String getName();
	
}
