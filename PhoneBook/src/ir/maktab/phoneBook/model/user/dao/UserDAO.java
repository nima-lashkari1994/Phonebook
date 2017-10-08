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
		
		System.out.println("constracuto ruuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuun");
		Session session = getSession();

		session.beginTransaction();
		if(session.createQuery("from Role where name='admin'").uniqueResult()==null)
		session.save(Role.getAdminRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
		session = getSession();

		session.beginTransaction();
		if(session.createQuery("from Role where name='head'").uniqueResult()==null)
		session.save(Role.getHeadRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
		session = getSession();

		session.beginTransaction();
		if(session.createQuery("from Role where name='simpleUser'").uniqueResult()==null)
		session.save(Role.getSimpleUserRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
		session = getSession();

		session.beginTransaction();
		if(session.createQuery("from Role where name='guest'").uniqueResult()==null)
		session.save(Role.getGuestRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
	}

	public static UserDAO getInstance() {
		return userDAOInstance;
	}

	@Override
	public boolean add(User e) {
		
		System.out.println(e + "  in dao");
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
		System.out.println(e + "  in dao");
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

	@Override
	public void update(User e) {

	}

	@Override
	public User getByUserName(String userName) {
		User user=null;
		Session session = getSession();		
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		user = session.get(User.class, userName);
		user.getUserName();
		tx.commit();
		}catch (HibernateException e) {
			
		e.printStackTrace();
		}
		session.close();
		System.out.println(user);
		return user;
	
		
	}
	

	@Override
	public List<User> getAll() {
		List<User> users=null;
		Session session = getSession();		
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		Query q=session.createQuery("from User");
		users=q.list();
		for(User user:users){
			user.getRole();
		}
		tx.commit();
		}catch (HibernateException e) {
			
		e.printStackTrace();
		}
		session.close();
		System.out.println(users);
		return users;
	}


}
