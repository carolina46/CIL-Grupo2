package components.daos.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;

import components.daos.HibernateUtil;
import components.daos.interfaces.CategoryDAO;
import model.business.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	private HibernateUtil util;
	
	public CategoryDAOImpl() {
		super();
	}

	@Override
	public boolean save(Category category) {
		return util.save(category);
	}

	@Override
	public boolean update(Category category) {
		return util.modify(category);
	}

	@Override
	public boolean remove(Category category) {
		return util.delete(category);
	}

	@Override
	public boolean removeById(Long key) {
		return util.delete(key);
	}

	@Override
	public Category getByID(Long key) {
		return util.getById(key, Category.class);
	}

	@Override
	public List<Category> getAll() {
		return util.getAll(Category.class);
	}

	@Override
	public Category getCategory(String name) {
		Category category=null;
		List<Category> list= util.getByText("name", name, Category.class);
		if(!list.isEmpty()) {
			category=list.get(0);
		}
		return category;
	}

}
