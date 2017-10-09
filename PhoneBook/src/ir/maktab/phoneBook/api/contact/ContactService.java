package ir.maktab.phoneBook.api.contact;


import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ir.maktab.phoneBook.base.AbstractEntityService;
import ir.maktab.phoneBook.core.SearchInput;
import ir.maktab.phoneBook.model.contact.Contact;
import ir.maktab.phoneBook.model.contact.logic.ContactManager;

@Path("contact/items")
public class ContactService extends AbstractEntityService<Contact> {

	@Override
	@POST
	public Response add(Contact e) {
		if(ContactManager.getInstance().add(e)){
			return Response.ok("Contact added").build();
		} else {
			return Response.ok("Something Went wrong!").build();
		}
	}


	@Override
	@DELETE
	public void remove(Contact e) {
		ContactManager.getInstance().delete(e);
	}
	
	
	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") Integer id) {
		ContactManager.getInstance().delete(id);
	}


	@Override
	@PUT
	public void update(Contact e) {
		ContactManager.getInstance().update(e);
	}

	@Override
	@GET
	public List<Contact> getAll() {
		return ContactManager.getInstance().list();
	}

	@Override
	@GET
	@Path("/{start}/{len}")
	public List<Contact> getAll(@PathParam("start")String start,@PathParam("len")String len) {
		return ContactManager.getInstance().list(start, len);
	}
	
	@GET
	@Path("/search")
	public List<Contact> search(@BeanParam SearchInput input){
		System.out.println(input);
		return ContactManager.getInstance().search(input);
	}
	
	

}
