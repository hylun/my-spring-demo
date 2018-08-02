package com.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/rest")
public interface RestfulService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Map> getUsers(@QueryParam("uid") int uid);

    @GET
    @Path("/primitive")
    @Produces(MediaType.TEXT_PLAIN)
    String testPrimitiveType();

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    Response add(@FormParam("id") int id, @FormParam("name") String name);

    @GET
    @Path("/exception")
    @Produces(MediaType.APPLICATION_JSON)
    void testException();
}
