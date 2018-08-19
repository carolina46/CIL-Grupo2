package components.daos.implementations;

import java.util.List;

import components.daos.HibernateUtil;
import components.daos.interfaces.MenuDAO;
import model.business.Menu;

public class MenuDAOImpl implements MenuDAO {

	private HibernateUtil util;
	
	public MenuDAOImpl() {
		super();
	}
	
	@Override
	public Long save(Menu menu) {
		return util.save(menu);
	}

	@Override
	public boolean update(Menu menu) {
		return util.modify(menu);
	}

	@Override
	public boolean remove(Menu menu) {
		return util.delete(menu);
	}

	@Override
	public boolean removeById(Long key) {
		return util.deleteById(key, Menu.class);
	}

	@Override
	public model.business.Menu getByID(Long key) {
		return util.getById(key, Menu.class);
	}

	@Override
	public List<model.business.Menu> getAll() {
		return util.getAll(Menu.class);
	}

	@Override
	public model.business.Menu getMenuByNameEqualsTo(String name) {
		return util.getEntityByTextEquals("name", name, Menu.class);
	}

}
