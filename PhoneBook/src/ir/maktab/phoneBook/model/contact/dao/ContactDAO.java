package ir.maktab.phoneBook.model.contact.dao;

import java.util.Collection;

import ir.maktab.phoneBook.base.AbstractEntityDAO;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Contact e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Contact e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact getByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Contact> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
