package ir.maktab.phoneBook.base;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractEntityDAO<E> implements EntityDAO<E> {
	
	

	private static final SessionFactory ourSessionFactory;

    static {
        try {
            ourSessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
// this is a test
    
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

}
