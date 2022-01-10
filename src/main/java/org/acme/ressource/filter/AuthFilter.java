package org.acme.ressource.filter;

import javax.annotation.Priority;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Priority(100)// notice prirority
@Provider    // JAX-RS magic annotation that is scanned at deploymenttime
@ConstrainedTo(RuntimeType.SERVER) // Server filter
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {

//        String method=requestContext.getRequest().getMethod();
//        String authHeader = requestContext.getHeaders().getFirst("traceId");
//        System.out.println(authHeader);
//        if (authHeader.isBlank() || authHeader.isEmpty()) {
//            throw new RuntimeException("hest");
//        }
    }

}

//