package ir.maktab.phoneBook.base;


import java.util.List;

import javax.ws.rs.core.Response;

public interface EntityService<E> {
	
	Response add(E e); // success -> 200  failed--> 406
	Response remove(E e);  // success -> 204   failed -> 406 
	Response update(E e);  //success ->200  failed -> 406
	List<E> getAll();
}
