package ir.maktab.phoneBook.model.contact.logic;


import java.util.List;

import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.core.ContactSearchInput;
import ir.maktab.phoneBook.model.contact.Contact;
import ir.maktab.phoneBook.model.contact.dao.ContactDAO;

public class ContactManager extends AbstractEntityManager<Contact> {
	
	private static ContactManager contactManagerInstance=new ContactManager();
	
	private ContactManager(){
		
	}
	
	public static ContactManager getInstance(){
		return contactManagerInstance;
	}

	@Override
	public boolean add(Contact e) {
		return ContactDAO.getInstance().add(e);
	}

	@Override
	public boolean update(Contact e) {
		return ContactDAO.getInstance().update(e);
		
	}

	@Override
	public boolean delete(Contact e) {
		return ContactDAO.getInstance().delete(e);
		
	}
	
	public boolean delete(int id) {
		return ContactDAO.getInstance().delete(ContactDAO.getInstance().getById(id));
		
	}

	@Override
	public List<Contact> list() {
		return ContactDAO.getInstance().getAll();
	}


	
	public List<Contact> search(ContactSearchInput input){
		if(input.getFirstName()==null){
			input.setFirstName("");
		}
		if(input.getLastName()==null){
			input.setLastName("");
		}
		if(input.getEmail()==null){
			input.setEmail("");
		}
		if(input.getHomeNumber()==null){
			input.setHomeNumber("");
		}
		if(input.getMobileNumber()==null){
			input.setMobileNumber("");
		}
	
		return ContactDAO.getInstance().search(input);
	}

}
