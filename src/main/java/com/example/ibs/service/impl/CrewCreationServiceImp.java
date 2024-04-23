package com.example.ibs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.resteasy.reactive.RestPath;

import com.example.ibs.request.CrewCreation;
import com.example.ibs.response.CrewCreationResponse;
import com.example.ibs.response.DeleteRestrictionResponse;
import com.example.ibs.response.PairingCreationResponse;
import com.example.ibs.service.CrewCreationService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CrewCreationServiceImp implements CrewCreationService {

    List<CrewCreation> crew=new ArrayList<>();

    public Response createCrew(CrewCreation crewCreation){

        boolean found = crew.stream()
        .anyMatch(restriction -> restriction.getId().equals(crewCreation.getId()));

        if(found){
            // return Response.ok(new PairingCreationResponse("404","error","already exist ",crewCreation)).build();
            return Response.ok(new CrewCreationResponse("404","error","already exist",new CrewCreation())).build();

        }

        crew.add(crewCreation);
        System.out.println(crewCreation);
        
        // return Response.ok(new PairingCreationResponse("200","success","pairing creation  are ",crewCreation)).build();
        return Response.ok(new CrewCreationResponse("200","success","crew created successfully",crewCreation)).build();
        
    }

    //getAll crew
    public Response getAllCrew(){

        List<CrewCreation> as = crew.stream()
        .filter(x -> x.getId() != null)  
        .collect(Collectors.toList());

        if(as.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).entity("the list is empty ").build();
        }
        return Response.status(Response.Status.FOUND).entity(as).build();
       
    }


//getcrewByID
    public Response getCrewById(String id){
        
        CrewCreation as = crew.stream()
        .filter(x -> x.getId().equals(id))
        .findFirst()
        .orElse(null);

        if (as == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No PairingCreation found with the provided ID: " + id)
                    .build();
        }
        


        return Response.ok(new CrewCreationResponse("200","success"," pair creation by Id ",as)).build();
    }


    //update crew
    public Response updateCrew(CrewCreation creation,@RestPath String id){
        CrewCreation as = crew.stream()
        .filter(x -> x.getId().equals(id))
        .findFirst()
        .orElse(null);

        if (as == null) {
            return Response.ok(new CrewCreationResponse("404","error"," not found",new CrewCreation())).build();
        }
        
        as.setCrew_Identifier(creation.getCrew_Identifier());
        as.setFirst_name(creation.getFirst_name());
        as.setLast_name(creation.getLast_name());
        as.setCrewType(creation.getCrewType());
        as.setDob(creation.getDob());

        return Response.ok(new CrewCreationResponse("200","success"," crew  update successfully ",as)).build();
    }

    //delete crew
    public Response deleteCrew(@RestPath String id){
        boolean found = crew.stream()
        .anyMatch(pair -> pair.getId().equals(id));

    if (found) {
       // Remove the object with the given id from the crewRestriction collection
       crew.removeIf(pair -> pair.getId().equals(id));
    //   System.out.println(crewRestriction);

      return Response.ok(new DeleteRestrictionResponse("200", "success", "crew pair id '" + id + "' deleted successfully")).build();

    }

    return Response.ok(new DeleteRestrictionResponse("404", "error", "Crew not deleted")).build();
    }

    
}
