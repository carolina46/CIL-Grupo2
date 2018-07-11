package components.daos;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtil {
	
	@Autowired
	private SessionFactory sessionFactory;

	public HibernateUtil() {
		super();
	}
	
	public <T> Serializable save(final T entity) {		
		Session session = this.sessionFactory.openSession();
		Serializable savedObject = null;
		
		try{
			Transaction tx = session.beginTransaction();
			savedObject = session.save(entity);
			tx.commit();
		}catch(Exception e){
			System.out.println("Error saving "+entity.toString());
		}finally{
			session.close();
		}
		
		return savedObject;
	}
	
	

}
