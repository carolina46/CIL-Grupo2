package components.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.business.Tag;

@Repository
@Transactional
public class TagDAO implements GenericDAO<Tag, Long>{

	@Override
	public void save(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tag getByID(Long key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
