package com.example.ibs.service;



import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.jboss.resteasy.reactive.RestPath;

import com.example.ibs.request.AssignPairing;
import com.example.ibs.request.CrewRestrictionAdd;
import com.example.ibs.request.CrewRestrictionUpdate;
import com.example.ibs.request.PairingCreation;


@Path("/ibs/crew")
public interface pairingService{

    @POST
    @Path("/createPairing")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response assignPairing( AssignPairing assignPairingInput);

    @POST
    @Path("/deAssignPairing/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deAssignPairing(@RestPath String id);


    @POST
    @Path("/addNewRestriction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewRestriction( CrewRestrictionAdd crewRestrictionAddInput);


    @DELETE
    @Path("/deleterestriction/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteRestriction( @RestPath String id );


    @POST
    @Path("/updateRestriction/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewRestrictionUpdate( CrewRestrictionUpdate crewRestrictionUpdate, @RestPath String id);


    //get pairing by id
    @GET
    @Path("/getPairingById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPairingById( @RestPath String id) ;

    //getall pairing
    @GET
    @Path("/getAllPairing/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllPairing( ) ;

   




}
