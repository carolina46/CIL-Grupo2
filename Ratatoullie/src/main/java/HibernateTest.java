import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import components.daos.RestaurantDAO;
import model.business.Restaurant;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ratatoullie-dispatcher-servlet.xml");
		
		RestaurantDAO resrautantDAO = context.getBean(RestaurantDAO.class);
		
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Starbucks");
				
		resrautantDAO.save(restaurant);
		
		
		List<Restaurant> list = resrautantDAO.list();
		
		for(Restaurant r : list){
			System.out.println("Restaurant List::"+r);
		}
		
		context.close();
	}

}
