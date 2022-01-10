package org.acme.ressource.filter;

import org.jboss.resteasy.core.interception.jaxrs.PostMatchContainerRequestContext;

import javax.annotation.Priority;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Priority(200)// notice prirority
@Provider    // JAX-RS magic annotation that is scanned at deploymenttime
@ConstrainedTo(RuntimeType.SERVER) // Server filter
public class RequestFilter2 implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        System.out.println(
                String.format("RequestFilter2 called: method %s on url %s",
                        requestContext.getRequest().getMethod(),
                        ((PostMatchContainerRequestContext) requestContext).getHttpRequest().getUri().getAbsolutePath())
        );
    }

}

