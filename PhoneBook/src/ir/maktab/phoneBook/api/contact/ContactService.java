package ir.maktab.phoneBook.api.contact;


import java.util.List;



import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.maktab.phoneBook.base.AbstractEntityService;
import ir.maktab.phoneBook.core.ContactSearchInput;
import ir.maktab.phoneBook.model.contact.Contact;
import ir.maktab.phoneBook.model.contact.logic.ContactManager;

@Path("contact/items")
public class ContactService extends AbstractEntityService<Contact> {
	

	@Override
	@POST
	public Response add(Contact e) {
		if(ContactManager.getInstance().add(e)){
			return Response.status(Status.NO_CONTENT).build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}


	@Override
	@DELETE
	public Response remove(Contact e) {
		if(ContactManager.getInstance().delete(e)){
			return Response.status(Status.NO_CONTENT).build();
		}
		else{
			return Response.status(Status.FORBIDDEN).build();
		}
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") Integer id) {
		if(ContactManager.getInstance().delete(id)){
			return Response.status(Status.NO_CONTENT).build();
		}
		else{
			return Response.status(Status.FORBIDDEN).build();
		}
	}


	@Override
	@PUT
	public Response update(Contact e) {
		if(ContactManager.getInstance().update(e)){
			return Response.status(Status.NO_CONTENT).build();
		}
		else{
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	@GET
	public List<Contact> getAll() {
		return ContactManager.getInstance().list();
	}

	
	@GET
	@Path("/search")
	public List<Contact> search(@BeanParam ContactSearchInput input){
		return ContactManager.getInstance().search(input);
	}
	
	

}
