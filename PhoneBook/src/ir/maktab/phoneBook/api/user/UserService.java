package ir.maktab.phoneBook.api.user;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


import ir.maktab.phoneBook.base.AbstractEntityService;
import ir.maktab.phoneBook.model.user.User;
import ir.maktab.phoneBook.model.user.logic.UserManager;

@Path("/user/items")
public class UserService extends AbstractEntityService<User>{

	@Override
	@POST
	public Response add(User e) {
		
		 if(UserManager.getInstance().add(e)){
			return Response.ok("done").build();
		 } else {
			 return Response.ok("Try another Username").build();
		 }
	}

	@GET
	@Path("/{userName}")
	public User getByUserName(@PathParam("userName")String userName) {
		User user=UserManager.getInstance().getByUserName(userName);
		if(user!=null){
			return user;
		}
		else{
			return null;
		}
	}


	@Override
	@DELETE
	public void remove(User e) {
		UserManager.getInstance().delete(e);
	}

	@DELETE
	@Path("/{userName}")
	public void remove(@PathParam("userName")String userName) {
		this.remove(this.getByUserName(userName));
	}

	@Override
	@PUT
	public void update(User e) {
		UserManager.getInstance().update(e);
	}

	@Override
	@GET
	public List<User> getAll() {
		return UserManager.getInstance().list();
	}

	@Override
	@GET
	@Path("/{start}/{len}")
	public List<User> getAll(@PathParam("start")String start,@PathParam("len") String len) {
		return UserManager.getInstance().list(start, len);
	}

}
