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
	public List<Tag> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getByText(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public void save(Tag tag) {
		util.save(tag);
	}

	@Override
	public void delete(Tag t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Tag t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
