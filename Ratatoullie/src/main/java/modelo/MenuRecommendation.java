package modelo;

import java.util.List;

/**
 * 
 * This class represents a recommendation about a Menu
 * 
 * @author CIL-Grupo2
 *
 */



public class MenuRecommendation extends Recommendation {
	
	private Menu menu;

	
		
	public MenuRecommendation(String description, List<Client> receivers, Menu menu) {
		super(description, receivers);
		this.menu = menu;
	}
	
	
	public Menu getMenu() {return menu;	}
	public void setMenu(Menu menu) {this.menu = menu;}


	
	

}
