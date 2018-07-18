package components.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import components.daos.interfaces.CategoryDAO;
import components.services.interfaces.CategoryService;
import model.business.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;
	
	public CategoryServiceImpl() {}
	
	@Override
	public boolean saveCategory(Category Category) {
		return categoryDAO.save(Category);
	}

	@Override
	public boolean updateCategory(Category Category) {
		return categoryDAO.update(Category);
	}

	@Override
	public boolean removeCategory(Category Category) {
		return categoryDAO.remove(Category);
	}

	@Override
	public boolean removeCategoryById(Long id) {
		return categoryDAO.removeById(id);
	}

	@Override
	public Category getCategoryByID(Long id) {
		return categoryDAO.getByID(id);
	}

	@Override
	public Category getCategoryByName(String name) {
		return categoryDAO.getCategory(name);
	}

	@Override
	public List<Category> getAllCategorys() {
		return categoryDAO.getAll();
	}

}
