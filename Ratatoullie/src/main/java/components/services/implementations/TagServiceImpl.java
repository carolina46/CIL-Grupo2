package components.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import components.daos.interfaces.TagDAO;
import components.services.interfaces.TagService;
import model.business.Tag;

@Service
@Transactional
public class TagServiceImpl implements TagService{

	@Autowired
	private TagDAO tagDAO;
	
	public TagServiceImpl() {}
	
	@Override
	public Long saveTag(Tag tag) {
		return tagDAO.save(tag);
	}

	@Override
	public boolean updateTag(Tag tag) {
		return tagDAO.update(tag);
	}

	@Override
	public boolean removeTag(Tag tag) {
		return tagDAO.remove(tag);
	}

	@Override
	public boolean removeTagById(Long id) {
		return tagDAO.removeById(id);
	}

	@Override
	public Tag getTagByID(Long id) {
		return tagDAO.getByID(id);
	}

	@Override
	public Tag getTagByName(String name) {
		return tagDAO.getTagByNameEqualsTo(name);
	}

	@Override
	public List<Tag> getAllTags() {
		return tagDAO.getAll();
	}

}
