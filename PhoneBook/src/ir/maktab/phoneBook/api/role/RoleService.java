package ir.maktab.phoneBook.api.role;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.maktab.phoneBook.base.AbstractEntityService;
import ir.maktab.phoneBook.model.role.Role;
import ir.maktab.phoneBook.model.role.logic.RoleManager;


@Path("role/items")
public class RoleService extends AbstractEntityService<Role> {

	@Override
	@POST
	public Response add(Role e) {
		if(RoleManager.getInstance().add(e)){
			return Response.status(Status.NO_CONTENT).build();
		}
		else{
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	@DELETE
	public Response remove(Role e) {
		if(RoleManager.getInstance().delete(e)){
			return Response.status(Status.NO_CONTENT).build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	@PUT
	public Response update(Role e) {
		if(RoleManager.getInstance().update(e)){
			return Response.status(Status.NO_CONTENT).build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	@GET
	public List<Role> getAll() {
		return RoleManager.getInstance().list();
		}
	
	
	@GET
	@Path("/{roleName}")
	public Response getRoleByName(@PathParam("roleName")String roleName){
		
		Role role=RoleManager.getInstance().getByName(roleName);
		if (role != null) {
			return Response.ok(role).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

}
