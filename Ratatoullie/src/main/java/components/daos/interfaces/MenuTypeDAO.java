package components.daos.interfaces;

import model.business.MenuType;

public interface MenuTypeDAO extends GenericDAO<MenuType>{

	public MenuType getMenuTypeByNameEqualsTo(String name);
	
}