package org.acme.ressource.filter;


import javax.annotation.Priority;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Priority(100)
@Provider
@ConstrainedTo(RuntimeType.SERVER)
public class TraceIdFilter implements ContainerRequestFilter {
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String header = requestContext.getHeaders().getFirst("traceId");
        System.out.println(header);
        if (header.isEmpty() || header.isEmpty() || header == null) {
            throw new RuntimeException("Trace id must be provided");
        }
    }
}
