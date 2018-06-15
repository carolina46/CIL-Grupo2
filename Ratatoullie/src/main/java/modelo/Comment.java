package modelo;

import java.util.Date;

/**
 * Represents a comment from a user about a restaurant
 * 
 * @author CIL-Grupo2
 */


public class Comment {

	private String description;
	private Date date; 
	

	//Methods associated with Date
	public Date getDate() {	return date;}
	public void setDate(Date date) { this.date = date;}
	
	//Methods associated with Description
	public String getDescription() { return description;}
	public void setDescription(String description) { this.description = description;}
	
	
}
