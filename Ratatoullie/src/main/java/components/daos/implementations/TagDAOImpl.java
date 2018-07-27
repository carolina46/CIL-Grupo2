package components.daos.implementations;

import java.util.List;

import components.daos.HibernateUtil;
import components.daos.interfaces.TagDAO;
import model.business.Tag;

public class TagDAOImpl implements TagDAO {

	private HibernateUtil util;
	
	public TagDAOImpl() {
		super();
	}
	
	@Override
	public boolean save(Tag tag) {
		//Saves a Tag if the tag's name doesn't exist already
		if(util.getEntityByTextEquals("name", tag.getName(), Tag.class) == null)
			return util.save(tag);
		else
			return false;
	}

	@Override
	public boolean update(Tag tag) {
		return util.modify(tag);
	}

	@Override
	public boolean remove(Tag tag) {
		return util.delete(tag);
	}

	@Override
	public boolean removeById(Long key) {
		return util.deleteById(key, Tag.class);
	}

	@Override
	public Tag getByID(Long key) {
		return util.getById(key, Tag.class);
	}

	@Override
	public List<Tag> getAll() {
		return util.getAll(Tag.class);
	}

	@Override
	public Tag getTagByNameEqualsTo(String name) {
		return util.getEntityByTextEquals("name", name, Tag.class);
	}

}
