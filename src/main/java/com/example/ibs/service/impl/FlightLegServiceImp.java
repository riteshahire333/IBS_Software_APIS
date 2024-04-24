package com.example.ibs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.ibs.request.FlightLegInfo;
import com.example.ibs.response.GlobalCreateResponse;
import com.example.ibs.response.GlobalDeleteResponse;
import com.example.ibs.service.FlightLegInfoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class FlightLegServiceImp implements FlightLegInfoService {

    List<FlightLegInfo> fd=new ArrayList<>();

    @Override
    public Response createFlight(FlightLegInfo flightLegInfo) {
        boolean found = fd.stream()
        .anyMatch(restriction -> restriction.getFlightLegInfoID().equals(flightLegInfo.getFlightLegInfoID()));

        if(found){
            return Response.ok(new GlobalCreateResponse("404","error","already exist ",flightLegInfo)).build();

        }

        fd.add(flightLegInfo);
        System.out.println(flightLegInfo);
        
        return Response.ok(new GlobalCreateResponse("200","success","Flight is created ",flightLegInfo)).build();
    }

    @Override
    public Response getAllFlight() {
        List<FlightLegInfo> as = fd.stream()
        .filter(x -> x.getFlightLegInfoID() != null)  
        .collect(Collectors.toList());
        System.out.println(as);

        if(as.isEmpty()){
            return Response.ok(new GlobalCreateResponse("404","error","not exist ",as)).build();

        }
        return Response.ok(new GlobalCreateResponse("200","success","List is ",as)).build();
    }

    @Override
    public Response getFlightById(String id) {
        
        FlightLegInfo as = fd.stream()
        .filter(x -> x.getFlightLegInfoID().equals(id))
        .findFirst()
        .orElse(null);

        if (as == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No pairing duty found with the provided ID: " + id)
                    .build();
        }
        


        return Response.ok(new GlobalCreateResponse("200","success","flight det by Id ",as)).build();
    }

    @Override
    public Response updateFlight(String id, FlightLegInfo flightLegInfo) {
        
        FlightLegInfo as = fd.stream()
        .filter(x -> x.getFlightLegInfoID().equals(id))
        .findFirst()
        .orElse(null);

        if (as == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No PairingDuty found with the provided ID: " + id)
                    .build();
        }

       
        
        as.setCarrierCode(flightLegInfo.getCarrierCode());
        as.setFlightNumber(flightLegInfo.getFlightNumber());
        as.setFlightDate(flightLegInfo.getFlightDate());
        as.setDepartureAirport(flightLegInfo.getDepartureAirport());
        as.setArrivalAirport(flightLegInfo.getArrivalAirport());
        as.setFlightType(flightLegInfo.getFlightType());
        as.setAircraftRegistration(flightLegInfo.getAircraftRegistration());
        as.setAircraftSubtype(flightLegInfo.getAircraftSubtype());
        as.setLegSequenceNumber(flightLegInfo.getLegSequenceNumber());



        
        return Response.ok(new GlobalCreateResponse("200","success","pairDuty update successfully ",as)).build();
    }

    @Override
    public Response deleteFlight(String id) {
        boolean found = fd.stream()
        .anyMatch(pair -> pair.getFlightLegInfoID().equals(id));

    if (found) {
       // Remove the object with the given id from the crewRestriction collection
       fd.removeIf(pair -> pair.getFlightLegInfoID().equals(id));
    //   System.out.println(crewRestriction);

      return Response.ok(new GlobalDeleteResponse("200", "success", "flight  '" + id + "' deleted ")).build();

    }

    return Response.ok(new GlobalDeleteResponse("404", "error", "flight '" + id + "' not founf")).build();

    }

}
