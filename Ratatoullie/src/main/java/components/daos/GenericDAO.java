package components.daos;

import java.util.List;

public interface GenericDAO<T> {
	
	public boolean save(T t);
	public boolean delete(T t);
	public boolean modify(T t);
	public String getByID(Long id);
	public List<T> getList();
	public T getByText(String text);
	
}
