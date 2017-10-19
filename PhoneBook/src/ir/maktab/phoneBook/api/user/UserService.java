package ir.maktab.phoneBook.api.user;

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
import ir.maktab.phoneBook.core.UserSearchInput;
import ir.maktab.phoneBook.model.user.User;
import ir.maktab.phoneBook.model.user.logic.UserManager;

@Path("/user/items")
public class UserService extends AbstractEntityService<User> {
	
	
	

	@Override
	@POST
	@Path("/signup")
	public Response add(User e) {

		if (UserManager.getInstance().add(e)) {
			return Response.status(Status.NO_CONTENT).build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@POST
	@Path("/signin")
	public Response signIn(User e) {

		User user = UserManager.getInstance().signIn(e);
		if (user != null) {
			return Response.ok(user).build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@GET
	@Path("/{userName}")
	public Response getByUserName(@PathParam("userName") String userName) {
		User user = UserManager.getInstance().getByUserName(userName);
		if (user != null) {
			return Response.ok(user).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	@DELETE
	public Response remove(User e) {
		if(UserManager.getInstance().delete(e)){
			return Response.status(Status.NO_CONTENT).build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@DELETE
	@Path("/{userName}")
	public Response remove(@PathParam("userName") String userName) {
		return this.remove((User) this.getByUserName(userName).getEntity());
	}

	@Override
	@PUT
	public Response update(User e) {
		if(UserManager.getInstance().update(e)){
			return Response.status(Status.NO_CONTENT).build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	@GET
	public List<User> getAll() {
		return UserManager.getInstance().list();
	}
	
	
	@GET
	@Path("/search")
	public List<User> search(@BeanParam UserSearchInput input){
		return UserManager.getInstance().search(input);
	}


}
