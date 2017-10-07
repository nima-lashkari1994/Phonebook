package ir.maktab.phoneBook.base;


import java.util.List;

public interface EntityDAO <E>{
	
	boolean add(E e);
	void delete (E e);
	void update(E e);
	E getByUserName(String userName);
	List<E> getAll();
	
}
