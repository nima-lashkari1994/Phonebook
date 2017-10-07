package ir.maktab.phoneBook.api.contact;

import java.util.Collection;

import javax.ws.rs.core.Response;

import ir.maktab.phoneBook.base.AbstractEntityService;
import ir.maktab.phoneBook.model.contact.Contact;

public class ContactService extends AbstractEntityService<Contact>{

	@Override
	public Response add(Contact e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Contact e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Contact e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Contact> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Contact> getAll(Integer start, Integer len) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
