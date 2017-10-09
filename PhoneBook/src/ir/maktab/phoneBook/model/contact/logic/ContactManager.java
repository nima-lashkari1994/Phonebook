package ir.maktab.phoneBook.model.contact.logic;


import java.util.List;

import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.core.SearchInput;
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
	public void update(Contact e) {
		ContactDAO.getInstance().update(e);
	}

	@Override
	public void delete(Contact e) {
		ContactDAO.getInstance().delete(e);
	}
	
	public void delete(int id) {
		ContactDAO.getInstance().delete(id);
	}

	@Override
	public List<Contact> list() {
		return ContactDAO.getInstance().getAll();
	}


	@Override
	public List<Contact> list(String start, String len) {
		int startIndex=Integer.parseInt(start);
		int endIndex=Integer.parseInt(len);
		return ContactDAO.getInstance().getAll().subList(startIndex,endIndex);
	}
	
	public List<Contact> search(SearchInput input){
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
