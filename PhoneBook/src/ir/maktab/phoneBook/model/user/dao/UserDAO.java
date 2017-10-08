package ir.maktab.phoneBook.model.user.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.model.role.Role;
import ir.maktab.phoneBook.model.user.User;

public class UserDAO extends AbstractEntityDAO<User> {

	private static UserDAO userDAOInstance = new UserDAO();

	private UserDAO() {
		init();
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
			x.printStackTrace();
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public void delete(User e) {
		Session session = getSession();

		session.beginTransaction();
		session.remove(e);
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
		init();
	}

	@Override
	public void update(User e) {
		Session session = getSession();
		if(e.getRole().equals(Role.getAdminRole()) && !e.getUserName().equals("admin")){
			return;
		}
		session.beginTransaction();
		Query q = session.createQuery("update User set password=:password , role=:role where userName=:userName");
		q.setParameter("userName", e.getUserName());
		q.setParameter("role", e.getRole());
		q.setParameter("password", e.getPassword());
		q.executeUpdate();
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
		init();
	}

	@Override
	public User getByUserName(String userName) {
		init();
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
		System.out.println(user);
		return user;

	}

	@Override
	public List<User> getAll() {
		init();
		List<User> users = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from User");
			users = q.list();
			for (User user : users) {
				user.getRole();
			}
			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		session.close();
		return users;
	}

	public void init() {

		initAdmin();
		initSimpleUser();
		initHead();
		initGuest();
	}

	public void initAdmin() {
		User admin = new User("admin", "admin", Role.getAdminRole());
		Session session = getSession();

		session.beginTransaction();
		if (session.createQuery("from Role where name='admin'").uniqueResult() == null)
			session.save(Role.getAdminRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();

		session = getSession();
		if (session.createQuery("from User where role='admin'").uniqueResult() == null) {
			session.beginTransaction();
			session.save(admin);
			try {
				session.getTransaction().commit();
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
		session.close();

	}

	public void initHead() {
		Session session = getSession();

		session.beginTransaction();
		if (session.createQuery("from Role where name='head'").uniqueResult() == null)
			session.save(Role.getHeadRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
	}

	public void initSimpleUser() {
		Session session = getSession();

		session.beginTransaction();
		if (session.createQuery("from Role where name='simpleUser'").uniqueResult() == null)
			session.save(Role.getSimpleUserRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
	}

	public void initGuest() {
		Session session = getSession();

		session.beginTransaction();
		if (session.createQuery("from Role where name='guest'").uniqueResult() == null)
			session.save(Role.getGuestRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
	}

}
