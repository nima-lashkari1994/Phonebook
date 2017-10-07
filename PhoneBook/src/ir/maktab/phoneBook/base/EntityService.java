package ir.maktab.phoneBook.base;

import java.util.Collection;

import javax.ws.rs.core.Response;

public interface EntityService<E> {
	
	Response add(E e);
	E getByUserName(String userName);
	void remove(E e);
	void remove(String userName);
	void update(E e);
	Collection<E> getAll();
	Collection<E> getAll(Integer start, Integer len);
}
