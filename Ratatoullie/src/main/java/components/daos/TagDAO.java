package components.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.business.Tag;

@Repository
@Transactional
public class TagDAO implements GenericDAO<Tag>{

	@Autowired
	private HibernateUtil util;
	
	@Override
	public boolean save(Tag tag) {
		return util.save(tag);
	}

	@Override
	public boolean delete(Tag t) {
		return util.delete(t);
		
	}
	
	@Override
	public boolean modify(Tag t) {
		return util.modify(t);
		
	}
	
	@Override
	public List<Tag> getList() {
		//IMPLEMENT
		return null;
	}

	@Override
	public Tag getByText(String text) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
