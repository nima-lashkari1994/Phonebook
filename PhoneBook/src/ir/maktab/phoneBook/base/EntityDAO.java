package ir.maktab.phoneBook.base;

import java.util.Set;

public interface EntityDAO <E>{
	
	boolean add(E e);
	void delete (E e);
	void update(E e);
	E getByUserName(String userName);
	Set<E> getAll();
	
}
