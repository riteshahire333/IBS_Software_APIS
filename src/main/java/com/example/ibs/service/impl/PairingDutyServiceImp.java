package com.example.ibs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.ibs.request.PairingDuty;
import com.example.ibs.response.GlobalCreateResponse;
import com.example.ibs.response.GlobalDeleteResponse;
import com.example.ibs.response.GlobalGetResponse;
import com.example.ibs.service.PairingDutyService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PairingDutyServiceImp implements PairingDutyService {



    List<PairingDuty> pd=new ArrayList<>();

    public Response createPairingDuty( PairingDuty pairingDuty){


        boolean found = pd.stream()
        .anyMatch(restriction -> restriction.getPairingDutyId().equals(pairingDuty.getPairingDutyId()));

        if(found){
            return Response.ok(new GlobalCreateResponse("404","error","already exist ",pairingDuty)).build();

        }

        pd.add(pairingDuty);
        System.out.println(pairingDuty);
        
        return Response.ok(new GlobalCreateResponse("200","success","pairing creation  are ",pairingDuty)).build();
      
    }



    public Response getPairingDuty( ){

        List<PairingDuty> as = pd.stream()
        .filter(x -> x.getPairingDutyId() != null)  
        .collect(Collectors.toList());

        if(as.isEmpty()){
            return Response.ok(new GlobalCreateResponse("404","error","already exist ",as)).build();

        }
        return Response.ok(new GlobalCreateResponse("200","success","List is ",as)).build();

        
        
      
    }


    public Response getPAiringDutyById( String id ){

        PairingDuty as = pd.stream()
        .filter(x -> x.getPairingDutyId().equals(id))
        .findFirst()
        .orElse(null);

        if (as == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No pairing duty found with the provided ID: " + id)
                    .build();
        }
        


        return Response.ok(new GlobalCreateResponse("200","success","pairingDuty get by id  are ",as)).build();
    }
        
    


    public Response updatePairingDuty(String id ,PairingDuty pairingDuty){


        PairingDuty as = pd.stream()
        .filter(x -> x.getPairingDutyId().equals(id))
        .findFirst()
        .orElse(null);

        if (as == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No PairingDuty found with the provided ID: " + id)
                    .build();
        }
        
        as.setDepartureStation(pairingDuty.getDepartureStation());
        as.setArrivalStation(pairingDuty.getArrivalStation());
        as.setPlannedStartDateTime(pairingDuty.getPlannedStartDateTime());
        as.setPlannedEndDateTime(pairingDuty.getPlannedEndDateTime());
        as.setFlightTimeMins(pairingDuty.getFlightTimeMins());
        as.setDutyTimeMins(id);


        
        return Response.ok(new GlobalCreateResponse("200","success","pairDuty update successfully ",as)).build();
    }


    @Override
    public Response deletePairingDuty(String id ){

        boolean found = pd.stream()
        .anyMatch(pair -> pair.getPairingDutyId().equals(id));

    if (found) {
       // Remove the object with the given id from the crewRestriction collection
       pd.removeIf(pair -> pair.getPairingDutyId().equals(id));
    //   System.out.println(crewRestriction);

      return Response.ok(new GlobalDeleteResponse("200", "success", "pairing duty '" + id + "' deleted ")).build();

    }

    return Response.ok(new GlobalDeleteResponse("404", "error", "pairing duty '" + id + "' not founf")).build();

        
    }



  





}
