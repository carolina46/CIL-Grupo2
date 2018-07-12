package components.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.business.Restaurant;

@Transactional
//CONSULTAR
public class RestaurantDAOImpl implements RestaurantDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory =  sessionFactory;
	}
		
	@Override
	public void save(Restaurant restaurant) {
		Session session = this.sessionFactory.openSession();
			
		try{
			Transaction tx = session.beginTransaction();
			session.save(restaurant);
			tx.commit();
		}catch(Exception e){
			System.out.println("Error saving Restaurant");
		}finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> list() {
		Session session = this.sessionFactory.openSession();
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		try{
			
			restaurants = session.createQuery("from Restaurant").list();
		}catch(Exception e){
			System.out.println("Error retrieving Restaurants list");
		}finally{
			session.close();
		}
		return restaurants;
	}
}
