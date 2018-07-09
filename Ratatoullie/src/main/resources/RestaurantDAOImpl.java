import javax.transaction.Transaction;

import org.hibernate.Session;

public class RestaurantDAOImpl implements RestaurantDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
	@Override
	public void sav(Restaurant restaurant) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(restaurant);
		tx.commit();
		session.close();
	}
	
	@Override
	public List<Restaurant> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> restaurants = session.createQuery("from Restaurant").list();
		session.close();
		return restaurants;
	}
}
