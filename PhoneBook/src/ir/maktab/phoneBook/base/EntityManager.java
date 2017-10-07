package ir.maktab.phoneBook.base;

import java.util.Set;

public interface EntityManager <E>{
	
	boolean add(E e);
	void update(E e);
	void delete(E e);
	Set<E> list();
	E getByUserName(String Name);
	E createNew();
}
