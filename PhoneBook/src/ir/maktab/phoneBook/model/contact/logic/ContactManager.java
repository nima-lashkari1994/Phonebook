package ir.maktab.phoneBook.model.contact.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.model.contact.Contact;

public class ContactManager extends AbstractEntityManager<Contact> {
	
	private static ContactManager contactManagerInstance=new ContactManager();
	
	private ContactManager(){
		
	}
	
	public static ContactManager getInstance(){
		return contactManagerInstance;
	}

	@Override
	public boolean add(Contact e) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void update(Contact e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Contact e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact createNew() {
		// TODO Auto-generated method stub
		return null;
	}

}
