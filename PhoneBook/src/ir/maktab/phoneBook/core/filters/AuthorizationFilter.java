package ir.maktab.phoneBook.core.filters;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import ir.maktab.phoneBook.model.role.Role;
import ir.maktab.phoneBook.model.user.User;
import ir.maktab.phoneBook.model.user.logic.UserManager;

@Provider
@Priority(2)
public class AuthorizationFilter implements ContainerRequestFilter {

	private String path;
	private String method;
	private User user;
	Response unauthorized = Response.status(Status.UNAUTHORIZED).entity("You cannot access this resource!").build();

	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		method = request.getMethod().toLowerCase();
		path = request.getUriInfo().getPath();
		
		
		if (path.contains("signin") || path.contains("signup")) {
			return;
		}

		if (AuthenticationFilter.userName == null || AuthenticationFilter.password == null) {
			request.abortWith(unauthorized);
		}

		
		user = UserManager.getInstance().getByUserName(AuthenticationFilter.userName);
		

		
		
		if (!user.getPassword().equals(AuthenticationFilter.password)) {
			request.abortWith(unauthorized);
		}
		
		if(user.getRole().equals(Role.getAdminRole())){
			return;
		}
		
		if(method.equals("post")){
			
			if(path.contains("contact/items")){
				
				if(!user.getRole().equals(Role.getGuestRole())){
					return;
				}
			}
		}

		if (method.equals("delete")) {
			
			if(path.contains("contact/items")){
				
				if(user.getRole().equals(Role.getHeadRole())){
					return;
				}
			}

		}
		
		if(method.equals("put")){
			
			if(path.contains("contact/items")){
				
				if(user.getRole().equals(Role.getHeadRole())){
					return;
				}
			}
			
		}
		
		if(method.equals("get")){
			if(path.contains("user/items")){
				if(path.contains("search")){
					request.abortWith(unauthorized);
				}
				
				if(!request.getUriInfo().getPathParameters().isEmpty()){
					return;
				}
			}
			
			if(path.contains("contact/items")){
				return;
			}
		}
			

		request.abortWith(unauthorized);
	}

}
