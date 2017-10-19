package ir.maktab.phoneBook.api.event;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import ir.maktab.phoneBook.base.AbstractEntityService;
import ir.maktab.phoneBook.model.event.Event;
import ir.maktab.phoneBook.model.event.logic.EventManager;

@Path("/event/items")
public class EventService extends AbstractEntityService<Event> {

	@Override
	public Response add(Event e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response remove(Event e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response update(Event e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	public List<Event> getAll() {
		return EventManager.getInstance().list();
	}

}
