package ir.maktab.phoneBook.model.event.logic;

import java.util.List;

import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.model.event.Event;
import ir.maktab.phoneBook.model.event.dao.EventDAO;

public class EventManager extends AbstractEntityManager<Event> {
	
	private static EventManager eventManagerInstance=new EventManager();
	
	private EventManager(){
		
	}
	
	public static EventManager getInstance(){
		return eventManagerInstance;
	}

	@Override
	public boolean add(Event e) {
		return EventDAO.getInstance().add(e);
	}

	@Override
	public boolean update(Event e) {
		return EventDAO.getInstance().update(e);
	}

	@Override
	public boolean delete(Event e) {
		return EventDAO.getInstance().delete(e);
	}

	@Override
	public List<Event> list() {
		return EventDAO.getInstance().getAll();
	}

}
