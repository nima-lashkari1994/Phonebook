package ir.maktab.phoneBook.api.user;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import ir.maktab.phoneBook.base.AbstractEntityService;
import ir.maktab.phoneBook.model.user.User;
import ir.maktab.phoneBook.model.user.dao.UserDAO;
import ir.maktab.phoneBook.model.user.logic.UserManager;

@Path("/user/items")
public class UserService extends AbstractEntityService<User>{

	@Override
	@POST
	public Response add(User e) {
		System.out.println(e+"  in api");
		 if(UserManager.getInstance().add(e)){
			return Response.ok("done").build();
		 } else {
			 return Response.ok("Duplicate Id").build();
		 }
	}

	@Override
	@GET
	@Path("/{userName}")
	public User getByUserName(@PathParam("userName")String userName) {
		return UserManager.getInstance().getByUserName(userName);
	}


	@Override
	@DELETE
	public void remove(User e) {
		UserManager.getInstance().delete(e);
	}

	@Override
	@DELETE
	@Path("/{userName}")
	public void remove(@PathParam("userName")String userName) {
		this.remove(this.getByUserName(userName));
	}

	@Override
	@PUT
	@Path("/update")
	public void update(User e) {
		UserManager.getInstance().update(e);
	}

	@Override
	@GET
	public List<User> getAll() {
		return UserManager.getInstance().list();
	}

	@Override
	public List<User> getAll(Integer start, Integer len) {
		// TODO Auto-generated method stub
		return null;
	}

}
