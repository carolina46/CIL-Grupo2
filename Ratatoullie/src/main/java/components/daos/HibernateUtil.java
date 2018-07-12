package components.daos;

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
	
	public <T> boolean save(final T entity) {	
		//Saves a generic the object entity
		Session session = this.sessionFactory.openSession();
		boolean saved = true;
		
		try{
			Transaction tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		}catch(Exception e){
			System.out.println("HibernateUtil: Error saving "+entity.toString());
			saved = false;
		}finally{
			session.close();
		}
		
		return saved;
	}
		
	public <T> boolean delete(T entity) {
		//Deletes a tuple from generic object T
		Session session = this.sessionFactory.openSession();
		boolean deleted = true;
		
		try{
			Transaction tx = session.beginTransaction();
			
			session.delete(entity);
			tx.commit();
		}catch(Exception e){
			System.out.println("HibernateUtil: Error deleting "+entity.toString());
			deleted = false;
		}finally{
			session.close();
		}
		
		return deleted;
	}

	public <T> boolean modify(final T entity) {
		//Modifies the generic entity
		Session session = this.sessionFactory.openSession();
		boolean modified = true;
		
		try{
			Transaction tx = session.beginTransaction();
			
			session.update(entity);
			tx.commit();
		}catch(Exception e){
			System.out.println("HibernateUtil: Error modifying "+entity.toString());
			modified = false;
		}finally{
			session.close();
		}
		
		return modified;
	}

}
