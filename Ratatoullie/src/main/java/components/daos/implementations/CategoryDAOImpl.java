package components.daos.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import components.daos.HibernateUtil;
import components.daos.interfaces.CategoryDAO;
import model.business.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private HibernateUtil util;
	
	public CategoryDAOImpl() {
		super();
	}

	@Override
	public boolean save(Category category) {
		//Saves a Category if the category's name doesn't exist already
		if (util.getEntitiesByText("name", category.getName(), Category.class) == null)
			return util.save(category);
		else
			return false;
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
		return util.deleteById(key, Category.class);
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
	public Category getCategoriesByName(String name) {
		return util.getEntityByText("name", name, Category.class);
	}

}
