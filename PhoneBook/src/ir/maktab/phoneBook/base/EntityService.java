package ir.maktab.phoneBook.base;


import java.util.List;

import javax.ws.rs.core.Response;

public interface EntityService<E> {
	
	Response add(E e);
	E getByUserName(String userName);
	void remove(E e);
	void remove(String userName);
	void update(E e);
	List<E> getAll();
	List<E> getAll(Integer start, Integer len);
}
