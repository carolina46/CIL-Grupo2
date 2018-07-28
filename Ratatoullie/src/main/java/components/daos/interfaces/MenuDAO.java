package components.daos.interfaces;

import model.business.Menu;

public interface MenuDAO extends GenericDAO<Menu>{
	
	public Menu getMenuByNameEqualsTo(String name);
}
