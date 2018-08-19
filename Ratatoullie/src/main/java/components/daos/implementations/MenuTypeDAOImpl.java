package components.daos.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import components.daos.HibernateUtil;
import components.daos.interfaces.MenuTypeDAO;
import model.business.MenuType;

@Repository
public class MenuTypeDAOImpl implements MenuTypeDAO {

	@Autowired
	private HibernateUtil util;
	
	public MenuTypeDAOImpl() {
		super();
	}
	
	@Override
	public Long save(MenuType menuType) {
		if (menuType.getName()==null) {
			return 0l;
		}
		else {
			//Saves a MenuType if the MenuType's name doesn't exist already
			if(util.getEntityByTextEquals("name", menuType.getName(), MenuType.class) == null)
				return util.save(menuType);
			else
				return 0l;
		}
	}

	@Override
	public boolean update(MenuType menuType) {
		if(menuType==null)
			return false;
		else 
			if(menuType.getName().equals(" ") || menuType.getOid()==null)
				return false;
			else 
				if(this.getByID(menuType.getOid())==null)
					return false;
				else
					return util.modify(menuType);
	}

	@Override
	public boolean remove(MenuType menuType) {
		if (menuType.getName()==null) {
			return false;
		}
		else {
			return util.delete(menuType);
		}
		
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
