package components.daos;

import java.util.List;

public interface GenericDAO<T> {
	
		public List<T> getList();
		public T getByText(String text);
		public void save(T t);
		public void delete(T t);
		public void modify(T t);
		public String getByID(Long id);
	

}
