package org.acme.ressource.filter;


import org.jboss.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Priority(1)
@Provider
@ConstrainedTo(RuntimeType.SERVER)
public class LogFilter implements ContainerRequestFilter {

    @Inject
    private Logger logger;

    @Override
    public void filter(ContainerRequestContext requestContext)  {
        try{
            byte[] bytes = requestContext.getEntityStream().readAllBytes();
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
            requestContext.setEntityStream(new ByteArrayInputStream(bytes));
            bytes = requestContext.getEntityStream().readAllBytes();
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
            requestContext.setEntityStream(new ByteArrayInputStream(bytes));

//            byte[] bytes = requestContext.getEntityStream().readAllBytes();
//
//            String content = new String(bytes, StandardCharsets.UTF_8);
//
//            logger.info("Request: \nMethod: " + requestContext.getMethod() + "\n"
//                    + "Header: " + requestContext.getHeaders() + "\n"
//                    + "content: " + content
//                    + "\n\n"
//            );
////            logger.info("Response: \nStatus: " + responseContext.getStatus() + "\n"
////                    + "Header: " + responseContext.getHeaders() +
////                    "\n\n"
////            );
//
//            requestContext.setEntityStream(new ByteArrayInputStream(bytes));

        } catch(IOException e ){

        }
    }

}
