package com.example.ibs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.ibs.request.PairingCreation;
import com.example.ibs.response.DeleteRestrictionResponse;
import com.example.ibs.response.PairingCreationResponse;
import com.example.ibs.service.PairingCreationService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PairingCreationServiceImp implements PairingCreationService {


    //pairing creation
   List<PairingCreation> pairCreation=new ArrayList<>();
   
    //pairing creation
    public Response createPairing( PairingCreation pairingCreation){




        boolean found = pairCreation.stream()
        .anyMatch(restriction -> restriction.getId().equals(pairingCreation.getId()));

        if(found){
            return Response.ok(new PairingCreationResponse("404","error","already exist ",pairingCreation)).build();

        }

        pairCreation.add(pairingCreation);
        System.out.println(pairingCreation);
        
        return Response.ok(new PairingCreationResponse("200","success","pairing creation  are ",pairingCreation)).build();
    }

//get all pairingcreation
    public Response getPairing(){

        List<PairingCreation> as = pairCreation.stream()
        .filter(x -> x.getId() != null)  
        .collect(Collectors.toList());

        if(as.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).entity("the list is empty ").build();
        }
        return Response.status(Response.Status.FOUND).entity(as).build();
    }



    //get pairing cration by id
    public Response getCreationPairingById(String id )
    
    {
    

        PairingCreation as = pairCreation.stream()
        .filter(x -> x.getId().equals(id))
        .findFirst()
        .orElse(null);

        if (as == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No PairingCreation found with the provided ID: " + id)
                    .build();
        }
        


        return Response.ok(new PairingCreationResponse("200","success"," pair creation by Id ",as)).build();


    
    }


    //update pair creation
    public Response updateCreationPairing(String id ,PairingCreation pairingCreation){

        PairingCreation as = pairCreation.stream()
        .filter(x -> x.getId().equals(id))
        .findFirst()
        .orElse(null);

        if (as == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No PairingCreation found with the provided ID: " + id)
                    .build();
        }
        
        as.setPairingCode(pairingCreation.getPairingCode());
        as.setStartDateTime(pairingCreation.getStartDateTime());
        as.setEndDateTime(pairingCreation.getEndDateTime());
        as.setFleet(pairingCreation.getFleet());
        as.setBase(pairingCreation.getBase());
        as.setCrewType(pairingCreation.getCrewType());

        return Response.ok(new PairingCreationResponse("200","success"," pair update successfully ",as)).build();
    }

//delete pair creation
    public Response deleteCreationPairing(String id ){

        boolean found = pairCreation.stream()
        .anyMatch(pair -> pair.getId().equals(id));

    if (found) {
       // Remove the object with the given id from the crewRestriction collection
       pairCreation.removeIf(pair -> pair.getId().equals(id));
    //   System.out.println(crewRestriction);

      return Response.ok(new DeleteRestrictionResponse("200", "success", "Crew restriction '" + id + "' deleted for pairing")).build();

    }

    return Response.ok("Not Found").build();
    }


}
