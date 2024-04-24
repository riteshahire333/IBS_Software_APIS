package com.example.ibs.service;

import org.jboss.resteasy.reactive.RestPath;

import com.example.ibs.request.PairingDuty;

import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ibs/v1")
public interface PairingDutyService {


    @POST
    @Path("/createPairingDuty")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPairingDuty( PairingDuty pairingDuty);

     //pairing creation
     @GET
     @Path("/getPairingDuty")
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public Response getPairingDuty( );


      //pairing creation by id
      @GET
      @Path("/getPairingDuty/{id}")
      @Produces(MediaType.APPLICATION_JSON)
      @Consumes(MediaType.APPLICATION_JSON)
      public Response getPAiringDutyById(@RestPath String id );


       //pairing creation update
       @POST
       @Path("/updatePairingDuty/{id}")
       @Produces(MediaType.APPLICATION_JSON)
       @Consumes(MediaType.APPLICATION_JSON)
       public Response updatePairingDuty(String id ,PairingDuty pairingDuty);

        //pairing creation delete
        @DELETE
        @Path("/deletePairingDuty/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response deletePairingDuty(String id );



}
