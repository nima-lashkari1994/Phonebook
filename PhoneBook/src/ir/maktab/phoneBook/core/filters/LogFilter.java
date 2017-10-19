package ir.maktab.phoneBook.core.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LogFilter implements ContainerResponseFilter {

	@Override
	
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		
	return;
	}

}
