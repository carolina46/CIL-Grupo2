package components.dtos.business;

public class NewRestaurantDTO {
	
	private Long responsible;
	private String name;
	private Long category;
	private Double latitude;
	private Double longitude;
	private Boolean visitor;
	private Boolean comensal;
	private Boolean gourmet;
	
	public NewRestaurantDTO() {	super();}
	
	public Long getResponsible() {return responsible;}
	public void setResponsible(Long responsible) {this.responsible = responsible;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public Long getCategory() {return category;}
	public void setCategory(Long category) {this.category = category;}
	
	public Double getLatitude() {return latitude;}
	public void setLatitude(Double latitude) {this.latitude = latitude;}
	
	public Double getLongitude() {return longitude;}
	public void setLongitude(Double longitude) {this.longitude = longitude;}
	
	public Boolean getVisitor() {return visitor;}
	public void setVisitor(Boolean visitor) {this.visitor = visitor;}
	
	public Boolean getComensal() {return comensal;}
	public void setComensal(Boolean comensal) {this.comensal = comensal;}
	
	public Boolean getGourmet() {return gourmet;}
	public void setGourmet(Boolean gourmet) {this.gourmet = gourmet;}


}
