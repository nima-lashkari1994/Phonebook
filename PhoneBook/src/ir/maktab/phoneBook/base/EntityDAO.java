package ir.maktab.phoneBook.base;


import java.util.List;

public interface EntityDAO <E>{
	
	boolean add(E e);
	boolean delete (E e);
	boolean update(E e);
	List<E> getAll();
}
