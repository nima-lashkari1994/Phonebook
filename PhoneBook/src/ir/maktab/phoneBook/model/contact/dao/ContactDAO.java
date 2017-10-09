package ir.maktab.phoneBook.model.contact.dao;


import java.io.File;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mysema.query.codegen.GenericExporter;
import com.mysema.query.codegen.Keywords;

import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.core.SearchInput;
import ir.maktab.phoneBook.model.contact.Contact;
import ir.maktab.phoneBook.model.role.Role;
import ir.maktab.phoneBook.model.user.User;

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
	public void delete(Contact e) {
		Session session = getSession();

		session.beginTransaction();
		session.remove(e);
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
	}
	
	
	public void delete(int id) {
		Session session = getSession();

		session.beginTransaction();
		Query q=session.createQuery("delete from Contact where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
	}

	@Override
	public void update(Contact e) {
		Session session = getSession();
		session.beginTransaction();
		Query q = session.createQuery("update Contact set "
				+ "firstName=:firstName ,"
				+ " lastName=:lastName ,"
				+ " mobileNumber=:mobileNumber ,"
				+ " homeNumber=:homeNumber ,"
				+ " email=:email"
				+ " where id=:id");
		q.setParameter("firstName", e.getFirstName());
		q.setParameter("lastName", e.getLastName());
		q.setParameter("mobileNumber", e.getMobileNumber());
		q.setParameter("homeNumber", e.getHomeNumber());
		q.setParameter("email", e.getEmail());
		q.setParameter("id", e.getId());
		q.executeUpdate();
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
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
		System.out.println(contact);
		return contact;
	}
	
	public List<Contact> search(SearchInput input){
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
		System.out.println(input);
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
