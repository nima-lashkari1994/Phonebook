package ir.maktab.phoneBook.base;


import java.util.List;

import ir.maktab.phoneBook.model.user.User;

public interface EntityManager <E>{
	
	boolean add(E e);
	void update(E e);
	void delete(E e);
	List<E> list();
	List<E> list(String start, String len);
}
