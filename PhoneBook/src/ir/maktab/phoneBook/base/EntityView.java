package ir.maktab.phoneBook.base;

import java.util.Collection;

public interface EntityView <E>{
	void print(E e);
	void print(Collection<E> e);
}
