package com.example.ibs.service;

import org.jboss.resteasy.reactive.RestPath;

import com.example.ibs.request.FlightLegInfo;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ibs/v2")
public interface FlightLegInfoService {


    @POST
    @Path("/createFlight")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFlight( FlightLegInfo flightLegInfo);

     //pairing creation
     @GET
     @Path("/getAllFlighty")
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public Response getAllFlight( );


      //pairing creation by id
      @GET
      @Path("/getFlight/{id}")
      @Produces(MediaType.APPLICATION_JSON)
      @Consumes(MediaType.APPLICATION_JSON)
      public Response getFlightById(@RestPath String id );


       //pairing creation update
       @POST
       @Path("/updateFlight/{id}")
       @Produces(MediaType.APPLICATION_JSON)
       @Consumes(MediaType.APPLICATION_JSON)
       public Response updateFlight(String id ,FlightLegInfo flightLegInfo);

        //pairing creation delete
        @DELETE
        @Path("/deleteFlight/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response deleteFlight(String id );
}
