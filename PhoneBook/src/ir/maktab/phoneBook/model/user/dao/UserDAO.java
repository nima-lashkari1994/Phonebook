package ir.maktab.phoneBook.model.user.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.core.ContactSearchInput;
import ir.maktab.phoneBook.core.UserSearchInput;
import ir.maktab.phoneBook.model.contact.Contact;
import ir.maktab.phoneBook.model.role.Role;
import ir.maktab.phoneBook.model.role.dao.RoleDAO;
import ir.maktab.phoneBook.model.role.logic.RoleManager;
import ir.maktab.phoneBook.model.user.User;

public class UserDAO extends AbstractEntityDAO<User> {

	private static UserDAO userDAOInstance = new UserDAO();

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		return userDAOInstance;
	}

	@Override
	public boolean add(User e) {
		init();

	

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

	public User signIn(User e) {

		init();
		Session session = getSession();

		session.beginTransaction();
		Query q = session.createQuery("from User where userName=:userName and password=:password");
		q.setParameter("userName", e.getUserName());
		q.setParameter("password", e.getPassword());
		User user = (User) q.uniqueResult();
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			session.close();
			return null;
		}
		session.close();
		return user;
	}

	@Override
	public boolean delete(User e) {
		
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
		init();
		return true;
	}

	@Override
	public boolean update(User e) {
		Session session = getSession();
		
		
		session.beginTransaction();
		
		try {
			session.update(e);
			session.getTransaction().commit();
		} catch (Exception x) {
			session.close();
			return false;
		}
		session.close();
		init();
		return true;
	}

	public User getByUserName(String userName) {
		User user = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			user = session.get(User.class, userName);
			tx.commit();
		} catch (HibernateException e) {
			session.close();
			return null;
		}
		session.close();
		return user;

	}

	@Override
	public List<User> getAll() {
		List<User> users = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from User");
			users = q.list();
			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		session.close();
		return users;
	}

	public void init() {

		RoleDAO.getInstance().init();
	}
	
	
	public List<User> search(UserSearchInput input){
		List<User> users = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from User where userName like :userName");
			
			q.setParameter("userName", "%"+input.getUserName()+"%");
			users = q.list();
			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		session.close();
		return users;
	}

	

}
