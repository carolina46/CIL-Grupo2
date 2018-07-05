package model;

/**
 * Represents Notification sent to the Responsible of a Restaurant, wich will point a comment.
 * It will have a variable readed originally in false. Once readed the notification won't be deleted. 
 * It will still be available for future reference just like Facebook notifications.
 * 
 * @author CIL-Grupo2
 */

public class Notification {

	private boolean readed;
	private Comment comment;

	public Notification() {
		readed = false;
	}

	public boolean isReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
}
