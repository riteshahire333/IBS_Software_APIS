package com.example.ibs.service;

import org.jboss.resteasy.reactive.RestPath;

import com.example.ibs.request.PairingCreation;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ibs")
public interface PairingCreationService {

    //pairing creation
    @POST
    @Path("/pairingCreation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPairing( PairingCreation pairingCreation);



   //pairing creation
       @GET
       @Path("/getpairingCreation")
       @Produces(MediaType.APPLICATION_JSON)
       @Consumes(MediaType.APPLICATION_JSON)
       public Response getPairing( );


        //pairing creation by id
        @GET
        @Path("/getByIdpairing/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response getCreationPairingById(@RestPath String id );


         //pairing creation update
         @POST
         @Path("/updatePairingCreation/{id}")
         @Produces(MediaType.APPLICATION_JSON)
         @Consumes(MediaType.APPLICATION_JSON)
         public Response updateCreationPairing(String id ,PairingCreation pairingCreation);

          //pairing creation delete
          @DELETE
          @Path("/deletePairingCreation/{id}")
          @Produces(MediaType.APPLICATION_JSON)
          @Consumes(MediaType.APPLICATION_JSON)
          public Response deleteCreationPairing(String id );

}
