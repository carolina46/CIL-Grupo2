package components.daos;

import java.io.Serializable;

import org.hibernate.SessionFactory;
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
		return sessionFactory.getCurrentSession().save(entity);
	}
	
	

}
