package components.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import components.daos.interfaces.MenuTypeDAO;
import components.services.interfaces.MenuTypeService;
import model.business.MenuType;

@Service
@Transactional
public class MenuTypeServiceImpl implements MenuTypeService{

	@Autowired
	private MenuTypeDAO menuTypeDAO;
	
	public MenuTypeServiceImpl() {}
	
	@Override
	public boolean saveMenuType(MenuType menuType) {
		return menuTypeDAO.save(menuType);
	}

	@Override
	public boolean updateMenuType(MenuType menuType) {
		return menuTypeDAO.update(menuType);
	}

	@Override
	public boolean removeMenuType(MenuType menuType) {
		return menuTypeDAO.remove(menuType);
	}

	@Override
	public boolean removeMenuTypeById(Long id) {
		return menuTypeDAO.removeById(id);
	}

	@Override
	public MenuType getMenuTypeByID(Long id) {
		return menuTypeDAO.getByID(id);
	}

	@Override
	public MenuType getMenuTypeByName(String name) {
		return menuTypeDAO.getMenuTypeByNameEqualsTo(name);
	}

	@Override
	public List<MenuType> getAllMenuTypes() {
		return menuTypeDAO.getAll();
	}

}

