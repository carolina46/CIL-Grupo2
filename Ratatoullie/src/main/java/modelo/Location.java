package modelo;

/**
 * Represents a Location given the Latitude and Longitude
 * @author CIL-Grupo2
 *
 */

public class Location {

	private Double latitude;
	private Double longitude;
	
	public Location(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
