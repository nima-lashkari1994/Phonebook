package ir.maktab.phoneBook.base;


import java.util.List;

public interface EntityManager <E>{
	
	boolean add(E e);
	void update(E e);
	void delete(E e);
	List<E> list();
	E getByUserName(String Name);
	E createNew();
}
