package ir.maktab.phoneBook.model.contact.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.core.ContactSearchInput;
import ir.maktab.phoneBook.model.contact.Contact;

public class ContactDAO extends AbstractEntityDAO<Contact> {
	
	private static  ContactDAO contactDAOInstance=new ContactDAO();
	
	private ContactDAO(){
		
	}
	
	public static ContactDAO getInstance(){
		return contactDAOInstance;
	}

	@Override
	public boolean add(Contact e) {
		Session session = getSession();

		session.beginTransaction();
		session.save(e);
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean delete(Contact e) {
		Session session = getSession();

		session.beginTransaction();
		session.remove(e);
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			return false;
		}
		session.close();
		return true;
	}
	

	@Override
	public boolean update(Contact e) {
		Session session = getSession();
		session.beginTransaction();
		try {
			session.update(e);
			session.getTransaction().commit();
		} catch (Exception x) {
			return false;
		}
		session.close();
		return true;
	}
	
	public Contact getById(int id){
		Contact contact = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			contact = session.get(Contact.class, id);
			tx.commit();
		} catch (HibernateException e) {
			session.close();
			return null;
		}
		session.close();
		return contact;
	}
	
	public List<Contact> search(ContactSearchInput input){
		List<Contact> contacts = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Contact where firstName like :firstName "
					+ "and lastName like :lastName "
					+ "and email like:email "
					+ "and mobileNumber like :mobileNumber "
					+ "and homeNumber like :homeNumber");
			
			q.setParameter("lastName", "%"+input.getLastName()+"%");
			q.setParameter("firstName", "%"+input.getFirstName()+"%");
			q.setParameter("email", "%"+input.getEmail()+"%");
			q.setParameter("homeNumber", "%"+input.getHomeNumber()+"%");
			q.setParameter("mobileNumber", "%"+input.getMobileNumber()+"%");
			contacts = q.list();
			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		session.close();
		return contacts;
	}

	@Override
	public List<Contact> getAll() {
		List<Contact> contacts = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Contact");
			contacts = q.list();
			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		session.close();
		return contacts;
	}

	
}
