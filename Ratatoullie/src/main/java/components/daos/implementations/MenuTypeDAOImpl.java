package components.daos.implementations;

import java.util.List;
import components.daos.HibernateUtil;
import components.daos.interfaces.MenuTypeDAO;
import model.business.MenuType;

public class MenuTypeDAOImpl implements MenuTypeDAO {

	private HibernateUtil util;
	
	public MenuTypeDAOImpl() {
		super();
	}
	
	@Override
	public boolean save(MenuType menuType) {
		//Saves a MenuType if the MenuType's name doesn't exist already
		if(util.getEntityByTextEquals("name", menuType.getName(), MenuType.class) == null)
			return util.save(menuType);
		else
			return false;
	}

	@Override
	public boolean update(MenuType menuType) {
		return util.modify(menuType);
	}

	@Override
	public boolean remove(MenuType menuType) {
		return util.delete(menuType);
	}

	@Override
	public boolean removeById(Long key) {
		return util.deleteById(key, MenuType.class);
	}

	@Override
	public MenuType getByID(Long key) {
		return util.getById(key, MenuType.class);
	}

	@Override
	public List<MenuType> getAll() {
		return util.getAll(MenuType.class);
	}

	@Override
	public MenuType getMenuTypeByNameEqualsTo(String name) {
		return util.getEntityByTextEquals("name", name, MenuType.class);
	}

	
}
