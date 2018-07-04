package model.filter;

import model.users.Responsible;

/**
 * Represents the configuration for sending notifications to the restaurant manager when there are new comments 
 * @author CIL-Grupo2
 */



public abstract class ConfigurationFilter {
	
	private Long oid;
	public Responsible responsible;
	
	public ConfigurationFilter(Responsible responsible) {
		this.responsible = responsible;
	}
	
	public Long getOid() {	return oid;	}
	public void setOid(Long oid) { this.oid = oid;	}
	
	public Responsible getResponsible() { return responsible;}
	public void setResponsible(Responsible responsible) { this.responsible = responsible;}

	
	/*
	 * They are used to inform if a comment about the restaurant can be made.
	 */
	public abstract boolean confirmVisitor();
	public abstract boolean confirmGourmet();
	public abstract boolean confirmComensal();
	
	/*
	 * They are used to determine if the restaurant responsible should be notified of a new comment
	 */
	public abstract void commentOfVisitor();
	public abstract void commentOfGourmet();
	public abstract void commentOfComensal();
	
	
}
