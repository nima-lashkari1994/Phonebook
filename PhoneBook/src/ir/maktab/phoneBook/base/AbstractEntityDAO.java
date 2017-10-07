package ir.maktab.phoneBook.base;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ir.maktab.phoneBook.model.user.User;

public abstract class AbstractEntityDAO<E> implements EntityDAO<E> {

	protected Session session;
	protected SessionFactory sessionFactory;
	protected Configuration conf;
	
	public AbstractEntityDAO() {
		
		conf = new Configuration();

		conf.configure();

		sessionFactory = conf.buildSessionFactory();
		
	}
	

}
