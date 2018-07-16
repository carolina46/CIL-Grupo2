package components.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class HibernateUtil {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;

	public HibernateUtil() {
		super();
	}
	
	/*Will be Spring who will be responsible for creating this object, 
	and will pass it to our class through this setter*/
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//Saves a generic the object entity
	public <T> boolean save(final T entity) {	
		boolean saved=true;
		try{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
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
		
	
	//Deletes a tuple from generic object T
	public <T> boolean delete(T entity) {
		boolean deleted = true;
		try{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
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
	
	//Delete the tuple with the id and from the class passed by parameter.
	public <T> boolean deleteById(Long id, Class<T> entityClass) {
		T entity = getById(id, entityClass);
		return delete(entity);
	}
	
	//Modifies the generic entity
	public <T> boolean modify(final T entity) {
		boolean modified = true;
		try{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
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
	
	//Returns all the tuples of the class passed by parameter
	public <T> List<T> getAll(Class<T> entityClass) {
		return getAllMatchQuery(" FROM " + entityClass.getName());
		
	}
	
	//Returns the tuple with the id and from the class passed by parameter.
	public <T> T getById(Long id, Class<T> entityClass) {
		T entity = null;
        try {
            session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			entity = session.get(entityClass, id);
        } finally {
            session.close();
        }
		return entity;
	}
	
	/*WARNING: Must be used when we are sure that the value of the attribute is not repeated.
	 * Returns the tuple from the class passed by parameter
	 *with the attribute passed by parameter 
	 *equals to the value passed by parameter.
	 */
	@SuppressWarnings("unchecked")
	public <T> T getByText(String atribute, String value, Class<T> entityClass) {
			T entity = null;
	        try {
	            session = this.sessionFactory.openSession();
				tx = session.beginTransaction();
				entity = (T) session.createQuery(" from "    + entityClass.getName()+
												 " where "   + atribute +
												 " = "       +value);
	        } finally {
	            session.close();
	        }
			return entity;
		}
	
	
	/*WARNING: Must be sure that the query is valid.
	 * Returns the tuples that meet the query passed as a parameter.
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getAllMatchQuery(String query) {
		List<T> list =null;
        try {
            session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
            list = (List<T>) session.createQuery(query).list();
        } finally {
            session.close();
        }
		return list;
	}
	
}
