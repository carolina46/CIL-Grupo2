package components.daos.interfaces;

import model.business.Tag;

public interface TagDAO extends GenericDAO<Tag>{

	public Tag getTagByNameEqualsTo(String name);
	
}
