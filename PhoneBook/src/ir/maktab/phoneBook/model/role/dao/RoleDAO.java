package ir.maktab.phoneBook.model.role.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.model.role.Role;
import ir.maktab.phoneBook.model.user.User;

public class RoleDAO extends AbstractEntityDAO <Role>{
	
	public static RoleDAO roleDAOInstance=new RoleDAO();
	
	private RoleDAO(){
		
	};
	
	public static RoleDAO getInstance(){
		return roleDAOInstance;
	}

	@Override
	public boolean add(Role e) {
		e.setName(e.getName().toLowerCase());
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
	public boolean delete(Role e) {
		if(e.equals(Role.getAdminRole()) || e.equals(Role.getGuestRole()) || e.equals(Role.getHeadRole()) || e.equals(Role.getSimpleUserRole())){
			return false;
		}
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
	public boolean update(Role e) {
		return false;
	}

	@Override
	public List<Role> getAll() {
		List<Role> roles = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from User");
			roles = q.list();
			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		session.close();
		return roles;
	}
	
	public Role getByName(String name){
		Role role = null;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			role = session.get(Role.class, name);
			tx.commit();
		} catch (HibernateException e) {
			session.close();
			return null;
		}
		session.close();
		return role;
	}
	
	public void init(){
		initAdmin();
		initGuest();
		initHead();
		initSimpleUser();
	}
	
	
	public void initAdmin() {
		User admin = new User("admin", "admin", Role.getAdminRole());
		Session session = getSession();

		session.beginTransaction();
		try {
			if (session.createQuery("from Role where name='admin'").uniqueResult() == null)
				session.save(Role.getAdminRole());
		} catch (Exception x) {
			session.save(Role.getAdminRole());
		}
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
		if (session.createQuery("from Role where name='simpleuser'").uniqueResult() == null)
			session.save(Role.getSimpleUserRole());
		try {
			session.getTransaction().commit();
		} catch (Exception x) {
			x.printStackTrace();
		}
		session.close();
	}

	public void initGuest() {

		User guest = new User("guest", "guest", Role.getGuestRole());
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

		session = getSession();
		if (session.createQuery("from User where role='guest'").uniqueResult() == null) {
			session.beginTransaction();
			session.save(guest);
			try {
				session.getTransaction().commit();
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
		session.close();

	}
}
