package model.business;

/**
 * Represents a Location given the Latitude and Longitude
 * @author CIL-Grupo2
 *
 */

public class Location {

	private Long oid; //For Hibernate
	private Double latitude;
	private Double longitude;
	
	public Location() {} //For Hibernate
	
	public Location(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Long getOid() { return oid;}

	public void setOid(Long oid) { this.oid = oid; }
	
	public Double getLatitude() { return latitude; }
	
	public void setLatitude(Double latitude) { this.latitude = latitude; }
	
	public Double getLongitude() { return longitude; }
	
	public void setLongitude(Double longitude) { this.longitude = longitude;}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("Location with oid = "+oid);
	}
}
