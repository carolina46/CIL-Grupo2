package model;

/**
 * Represents Notification sent to the Responsible of a Restaurant, wich will point a comment.
 * It will have a variable readed originally in false. Once readed the notification won't be deleted. 
 * It will still be available for future reference just like Facebook notifications.
 * 
 * @author CIL-Grupo2
 */

public class Notification {
	
	private Long oid; //For Hibernate
	private boolean readed;
	private Comment comment;

	public Notification() {} //For Hibernate
	
	public Notification(Comment comment) {	
		super();
		this.comment=comment;
		readed = false;	
	}

	public Long getOid() { return oid; }

	public void setOid(Long oid) { this.oid = oid; }

	
	public boolean isReaded() {	return readed;}
 	
	public void setReaded(boolean readed) {	this.readed = readed;}
	
	
	public Comment getComment() {return comment;}

	public void setComment(Comment comment) { this.comment = comment;}
	
	@Override
	public String toString() { // For logging purposes, instead of printing the hash of the object, toString() will return useful values
		return ("Notification with oid = "+oid);
	}
}
