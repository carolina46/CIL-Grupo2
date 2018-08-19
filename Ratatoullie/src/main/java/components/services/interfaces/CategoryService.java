package components.services.interfaces;

import java.util.List;
import model.business.Category;

public interface CategoryService {
	
	public Long saveCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean removeCategory(Category category);
	public boolean removeCategoryById(Long id);
	public Category getCategoryByID(Long id);
	public Category getCategoryByName(String name);
	public List<Category> getAllCategorys();

}
