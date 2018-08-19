package components.daos.interfaces;

import java.util.List;

/*
 * GenericDao interface contains common methods used by multiple DAO classes. 
 *  
 * @param <E> Represent Model class.
 */
public interface GenericDAO<E> {
	
		public Long save(E entity) ;
	    public boolean update(E entity) ;
	    public boolean remove(E entity);
	    public boolean removeById(Long key);
	    public E getByID(Long key);
	    public List<E> getAll();
}
