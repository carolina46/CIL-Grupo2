package components.services.interfaces;

import java.util.List;
import model.business.Tag;

public interface TagService {
	public boolean saveTag(Tag tag);
	public boolean updateTag(Tag tag);
	public boolean removeTag(Tag tag);
	public boolean removeTagById(Long id);
	public Tag getTagByID(Long id);
	public Tag getTagByName(String name);
	public List<Tag> getAllTags();

}
