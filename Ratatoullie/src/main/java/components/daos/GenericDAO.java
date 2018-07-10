package components.daos;

import java.util.List;

/*
 * GenericDao interface contains common methods used by multiple DAO classes. 
 * The letter E represent Model class and letter K represent primary key type. 
 */
public interface GenericDAO<E,K> {
	
		public void save(E entity) ;
	    public void update(E entity) ;
	    public void remove(E entity);
	    public E getByID(K key);
	    public List<E> getAll() ;
}
