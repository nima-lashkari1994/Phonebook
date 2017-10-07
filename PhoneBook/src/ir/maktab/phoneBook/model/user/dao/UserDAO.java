package ir.maktab.phoneBook.model.user.dao;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.model.user.User;

public class UserDAO extends AbstractEntityDAO<User> {
	
	private static UserDAO userDAOInstance=new UserDAO();
	private UserDAO(){
		
	}
	
	public static UserDAO getInstance(){
		return userDAOInstance;
	}

	@Override
	public boolean add(User e) {
		
		
		
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();

		session.save(e);
		try{
		session.getTransaction().commit();
		}catch(Exception x){
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public void delete(User e) {
		
		Session session=sessionFactory.openSession();

		
		session.beginTransaction();

		session.delete(e);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(User e) {
		
		Session session=sessionFactory.openSession();


		session.beginTransaction();
		Query q=session.createQuery("UPDATE User set password = :password "  + 
	             "WHERE userName = :userName");
		q.setParameter("userName", e.getUserName());
		q.setParameter("password", e.getPassword());
		q.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User getByUserName(String userName) {
		
		Session session=sessionFactory.openSession();

		
		session.beginTransaction();
		Query q=session.createQuery("from User where userName=:userName");
		q.setParameter("userName", userName);
		User user=(User) q.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public Set<User> getAll() {
		
		Session session=sessionFactory.openSession();

		
		session.beginTransaction();
		Query q=session.createQuery("from User");
		Set<User> users= (Set<User>) q.list();
		session.getTransaction().commit();
		session.close();
		return users;
	}

}
