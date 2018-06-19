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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
