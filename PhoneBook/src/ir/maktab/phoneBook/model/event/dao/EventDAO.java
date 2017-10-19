package ir.maktab.phoneBook.model.event.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.model.event.Event;
import ir.maktab.phoneBook.model.user.User;

public class EventDAO extends AbstractEntityDAO<Event>{
	
	private static EventDAO eventDAOInstance = new EventDAO();
	
	private EventDAO(){
		
	}
	
	public static EventDAO getInstance(){
		return eventDAOInstance;
	}

	@Override
	public boolean add(Event e) {
		Session session = getSession();

		session.beginTransaction();
		session.save(e);
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			session.close();
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean delete(Event e) {
		Session session = getSession();

		session.beginTransaction();
		session.remove(e);
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			session.close();
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean update(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Event> getAll() {
		List<Event> events = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Events");
			events = q.list();
			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		session.close();
		return events;
	}

	

}
