import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import components.daos.implementations.RestaurantDAOImpl;
import model.business.Restaurant;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/mvc-dispatcher-servlet.xml");
		
		RestaurantDAOImpl resrautantDAO = context.getBean(RestaurantDAOImpl.class);
		
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Starbucks");
				
		resrautantDAO.save(restaurant);
		
		
		List<Restaurant> list = resrautantDAO.getAll();
		
		for(Restaurant r : list){
			System.out.println("Restaurant List::"+r);
		}
		
		context.close();
	}

}
