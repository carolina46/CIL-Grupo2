package modelo;

/**
 * 
 * This Class represents the vote made to a Menu
 * 
 * @author CIL-Grupo2
 *
 */
public class MenuVote extends Vote {
	
	private Menu menu;

	public MenuVote(Menu menu, Integer value) {
		super(value);
		this.menu = menu;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
