package model.users;

import model.Comment;

/**
 * Represents a Administrator of the system.
 * Can delete comments of the clients.
 * Etc.
 * @author CIL-Grupo2
 */

public class Administrator extends User {
	
	public Administrator() {} //For Hibernate

	public Administrator(String fullName, String user, String password) {
		super(fullName, user, password);
	}

	/*IMPLEMENTE*/ public void deleteComment(Client clente, Comment comment) {};
}
