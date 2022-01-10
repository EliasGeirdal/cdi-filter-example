package org.acme.ressource;

import org.acme.ressource.dto.CarDTO;
import org.acme.ressource.dto.CreateCarDTO;
import org.acme.ressource.dto.UpdateCarDTO;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/cars")
public class CarResource {

    @Inject
    Logger logger;

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<CarDTO> getCars() {
        return Arrays.asList(
                new CarDTO("1234565", "AUDI", "8", 2020, "nice"),
                new CarDTO("1234565", "VW", "8", 2019, "nice")
        );
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{sn}")
    public CarDTO getCar(@PathParam("sn") String sn) {
        logger.info("calling getCAr");
        return new CarDTO("1234565", "VW", "8", 2019, "nice");
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public CarDTO createCar(CreateCarDTO createCarDTO) {

        return new CarDTO("34567", createCarDTO.getType(), createCarDTO.getModel(), createCarDTO.getProductionYear(), createCarDTO.getStatus());
    }

}
