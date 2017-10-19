package ir.maktab.phoneBook.core.filters;

import java.io.IOException;


import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

@Provider
@Priority(1)
public class AuthenticationFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	public static String userName;
	public static String password;

	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		
		List<String> authHeader = request.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if (authHeader != null && authHeader.size() > 0) {
			String authToken = authHeader.get(0);
			
			authToken = authToken.replaceFirst("[B|b]asic ", "");
			 
	        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(authToken);
	        String [] decodedString=new String(decodedBytes).split(":");
	
			userName=decodedString[0];
			password=decodedString[1];
			
			return;
			
		}
		
	}

}
