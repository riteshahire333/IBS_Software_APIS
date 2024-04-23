package com.example.ibs.service;

import org.jboss.resteasy.reactive.RestPath;

import com.example.ibs.request.CrewCreation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
public interface CrewCreationService {


    @POST
    @Path("/createCrew")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCrew(CrewCreation crewCreation);


    @GET
    @Path("/getCrew")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCrew();

    @GET
    @Path("/getCrew/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCrewById(@RestPath String id);

    @PUT
    @Path("/updateCrew/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCrew(CrewCreation creation,@RestPath String id);

    @DELETE
    @Path("/deleteCrew/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCrew(@RestPath String id);
}
