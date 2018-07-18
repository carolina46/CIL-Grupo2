package components.daos.interfaces;

import model.business.Category;

public interface CategoryDAO extends GenericDAO<Category>{
	
	public Category getCategory(String name);
	

}