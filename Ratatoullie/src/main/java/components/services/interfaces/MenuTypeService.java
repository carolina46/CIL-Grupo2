package components.services.interfaces;

import java.util.List;
import model.business.MenuType;

public interface MenuTypeService {
	public Long saveMenuType(MenuType menuType);
	public boolean updateMenuType(MenuType menuType);
	public boolean removeMenuType(MenuType menuType);
	public boolean removeMenuTypeById(Long id);
	public MenuType getMenuTypeByID(Long id);
	public MenuType getMenuTypeByName(String name);
	public List<MenuType> getAllMenuTypes();

}
