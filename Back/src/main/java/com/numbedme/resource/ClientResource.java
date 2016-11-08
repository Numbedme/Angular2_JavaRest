package com.numbedme.resource;

import com.numbedme.dao.ClientService;
import com.numbedme.model.Client;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 03.11.2016.
 */

@Path("/clients")
@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {

    @EJB private ClientService service;

    @GET
    public List<Client> findAllClients(){
        return service.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findClient(@PathParam("id") int id){
        Client c;
        if ((c = service.find(id)) != null){
            return Response.ok(c).build();
        }
        else return Response.status(404).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postClient(Client client){
        service.persist(client);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response mergeClient(Client c){
        if (service.find(c.getId()) == null) {
            return Response.status(404).build();
        }
        service.merge(c);
        return Response.ok().build();
    }
}
