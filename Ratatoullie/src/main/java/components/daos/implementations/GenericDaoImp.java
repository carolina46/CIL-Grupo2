package components.daos.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import components.daos.interfaces.GenericDAO;

/**
 * 
 * Represent the implementation of DAO with Hibernate.
 * 
 * @param <E> Represent Model class.
 * @param <K> Represent primary key type.
 */

@Repository
public abstract class GenericDaoImp<E, K extends Serializable> implements GenericDAO<E, K> {
    
	@Autowired
    private SessionFactory sessionFactory;
     
    protected Class<? extends E> daoType;
     
    /**
    * By defining this class as abstract, we prevent Spring from creating 
    * instance of this class If not defined as abstract, 
    * getClass().getGenericSuperClass() would return Object. There would be 
    * exception because Object class does not have constructor with parameters.
    */
    public GenericDaoImp() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
     
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
     
    @Override
    public boolean save(E entity) {
        currentSession().save(entity);
        return true;
    }
     
    @Override
    public boolean update(E entity) {
        currentSession().saveOrUpdate(entity);
        return true;
    }
     
    @Override
    public boolean remove(E entity) {
        currentSession().delete(entity);
        return true;
    }
     
    @Override
    public E getByID(K key) {
        return (E) currentSession().get(daoType, key);
    }
     
    @Override
    public List<E> getAll() {
        return currentSession().createCriteria(daoType).list();
    }
}