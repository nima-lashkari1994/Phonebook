package ir.maktab.phoneBook.base;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces({MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
@Consumes(MediaType.APPLICATION_JSON)
public abstract class AbstractEntityService<E> implements EntityService<E> {

}
