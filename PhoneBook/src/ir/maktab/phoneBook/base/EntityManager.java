package ir.maktab.phoneBook.base;


import java.util.List;



public interface EntityManager <E>{
	
	boolean add(E e);
	boolean update(E e);
	boolean delete(E e);
	List<E> list();
}
