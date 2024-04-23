package com.example.ibs.service.impl;

import com.example.ibs.service.pairingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import com.example.ibs.request.AssignPairing;

import com.example.ibs.request.CrewRestrictionAdd;

import com.example.ibs.request.CrewRestrictionUpdate;
import com.example.ibs.request.PairingCreation;
import com.example.ibs.response.CrewRestrictionAddResponse;
import com.example.ibs.response.CrewRestrictionUpdateResponse;
import com.example.ibs.response.DePairingAssigned;
import com.example.ibs.response.DeleteRestrictionResponse;
import com.example.ibs.response.PairingAssigned;
import com.example.ibs.response.PairingByIdResponse;
import com.example.ibs.response.PairingCreationResponse;

@Slf4j
@ApplicationScoped
public class pairingServiceImpl implements pairingService {



   List<AssignPairing> assgn=new ArrayList<>();
   List<CrewRestrictionAdd> crewRestriction=new ArrayList<>();
  
   
   //pairing creation
   List<PairingCreation> pairCreation=new ArrayList<>();



    @Override
    public Response deAssignPairing(String id) {

        boolean found = assgn.stream()
        .anyMatch(restriction -> restriction.getId().equals(id));



      
        Optional<String> pairingId = assgn.stream()
                .filter(assign -> assign.getId().equals(id))
                .map(AssignPairing::getPairingId)
                .findFirst();

    

    
   
                     

        List<String> list = new ArrayList<>(List.of("c1", "c2", "c3"));
        
       

        if(found){

           
             // Remove the object with the given id from the crewRestriction collection
             assgn.removeIf(restriction -> restriction.getId().equals(id));

             

            System.out.println(assgn);

            // List<String> as = assgn.stream()
            // .filter(x -> x.getId() != null) 
            // .map(AssignPairing::getCrewMemberId) 
            // .collect(Collectors.toList());

            // Optional<String> pairingId = assgn.stream()
            // .filter(assign -> assign.getId().equals(id))
            // .map(AssignPairing::getPairingId)
            // .findFirst();

            // System.out.println("inside found"+pairingId.get());

        List<String> crew=new ArrayList<>();
        if (pairingId.isPresent()) {

        System.out.println("Pairing ID found: " + pairingId.get());

         crew = assgn.stream()
        .filter(x -> x.getPairingId().equals(pairingId.get())) 
        .map(AssignPairing::getCrewMemberId) 
        .collect(Collectors.toList());
        System.out.println(crew);
        System.out.println("hiiiiiiiiiiiiiiiiiiiii");

    }else{
        System.out.println("not present ");
    }

           
            return Response.ok(new DePairingAssigned("200", "success", "Crew deassign to pairing", crew)).build();
        }
        else{
            return Response.ok(new DePairingAssigned("404", "error", "Crew deassign not pairing", List.of(""))).build();
        }
        
       

        // List<String> list = new ArrayList<>(List.of("c1", "c2", "c3"));

        // return Response.ok(new DePairingAssigned("0", "success", "Crew deassign to pairing", list)).build();
    }



    @Override
    public Response addNewRestriction(CrewRestrictionAdd crewRestrictionAddInput) {
        
       System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiii"+crewRestrictionAddInput);


       // Check if crewmemberId and restrcitedCrewId match
    if (crewRestrictionAddInput.getCrewmemberId().equals(crewRestrictionAddInput.getRestrcitedCrewId())) {
        return Response.ok(new PairingAssigned("400", "error", "CrewMemberId and restrcitedCrewId cannot be the same", List.of())).build();
    }

        


        boolean found = crewRestriction.stream()
        .anyMatch(restriction -> restriction.getId().equals(crewRestrictionAddInput.getId()));


        if(found){
            return Response.ok(new PairingAssigned("404", "error", "Id Already exist",List.of())).build();
        }



        
        crewRestriction.add(crewRestrictionAddInput);



        // List<String> list1 = new ArrayList<>();
        // list1.add(crewRestrictionAddInput.getId());


       List<String> list1 = crewRestriction.stream()
       .filter(x -> x.getRestrcitedCrewId().equals(crewRestrictionAddInput.getRestrcitedCrewId())) 
       //.map(CrewRestrictionAdd::getRestrcitedCrewId) 
       .map(pair -> pair.getRestrcitedCrewId() + "    " + pair.getCrewmemberId())
       .collect(Collectors.toList());

    //    List<String> crewRest = crewRestriction.stream()
    // .map(pair -> pair.getRestrcitedCrewId() + "    " + pair.getCrewmemberId())
    // .collect(Collectors.toList());


    
         


       // return Response.ok(new DePairingAssigned("200", "success", "Crew restriction added to pairing", list1)).build();
        return Response.ok(new CrewRestrictionAddResponse(list1)).build();
    }





    @Override
    public Response deleteRestriction(String id) {

       

        boolean found = crewRestriction.stream()
        .anyMatch(restriction -> restriction.getId().equals(id));

    if (found) {
       // Remove the object with the given id from the crewRestriction collection
      crewRestriction.removeIf(restriction -> restriction.getId().equals(id));
    //   System.out.println(crewRestriction);

      return Response.ok(new DeleteRestrictionResponse("200", "success", "Crew restriction '" + id + "' deleted for pairing")).build();

    }

     else {
        // Return an error response if the restriction is not found
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        return Response.status(Response.Status.NOT_FOUND)
                        .entity(new DeleteRestrictionResponse("404", "error", "Crew restriction '" + id + "' not found"))
                        .build();
    }




        // TODO Auto-generated method stub
        // return Response.ok(new DeleteRestrictionResponse("0", "success", "Crew restriction '" + id+ "'' deleted for pairing")).build();
    }

    @Override
    public Response addNewRestrictionUpdate(CrewRestrictionUpdate crewRestrictionUpdate, String id) {


        System.out.println("update");

        // TODO Auto-generated method stub


        CrewRestrictionAdd restrictionToUpdate = null;
        // for (CrewRestrictionAddInput input : crewRestrictionAddInputList) {
            for (CrewRestrictionAdd restriction : crewRestriction) {
                if (restriction.getId().equals(id)) {
                    restrictionToUpdate = restriction;
                    System.err.println(restrictionToUpdate);
                    break;
                }
            }
        
    
        if (restrictionToUpdate != null) {
            // Update the restriction with the new values
            restrictionToUpdate.setCrewmemberId(crewRestrictionUpdate.getCrewmemberId());
            restrictionToUpdate.setRestriction_type(crewRestrictionUpdate.getRestriction_type());
            restrictionToUpdate.setFromDate(crewRestrictionUpdate.getFromDate());
            restrictionToUpdate.setToDate(crewRestrictionUpdate.getToDate());
            restrictionToUpdate.setRestrcitedCrewId(crewRestrictionUpdate.getRestrcitedCrewId());

            
    
            // Return the response
            return Response.ok(new CrewRestrictionUpdateResponse("200", "success", "Crew restriction updated for pairing", id)).build();
        } else {
            // Return an error response if the restriction is not found
            return Response.status(Response.Status.NOT_FOUND)
                            .entity(new CrewRestrictionUpdateResponse("404", "error", "Crew restriction '" + id + "' not found", id))
                            .build();
        }

        // return Response.ok(new CrewRestrictionUpdateResponse("0", "success", "Crew restriction update for pairing", id)).build();
    }




    public Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Adjust the format as per your date strings
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            // Handle the parse exception according to your application's requirements
            e.printStackTrace();
            return null;
        }
    }
    
    //@Path("/ibs/crew/createPairing")
    @Override
    public Response assignPairing(AssignPairing assignPairingInput) {

    
        if(assignPairingInput.getCrewMemberId().isEmpty()|| assignPairingInput.getPairingId().isEmpty()){
            return Response.ok(new PairingAssigned("404", "error", "can not be null fields must contain values", List.of())).build();
        }

        boolean found = assgn.stream()
        .anyMatch(restriction -> restriction.getId().equals(assignPairingInput.getId()));


          // Check if the new assignment overlaps with any existing assignment for the same crew member and pairing
    // boolean overlap = assgn.stream().anyMatch(existing -> {
    //     if (existing.getCrewMemberId().equals(assignPairingInput.getCrewMemberId()) &&
    //         existing.getPairingId().equals(assignPairingInput.getPairingId())) {
    //         Date existingStart = parseDate(existing.getAssignmentStartDateTime());
    //         Date existingEnd = parseDate(existing.getAssignmentEndDateTime());
    //         Date newStart = parseDate(assignPairingInput.getAssignmentStartDateTime());
    //         Date newEnd = parseDate(assignPairingInput.getAssignmentEndDateTime());
    //         System.out.println(newStart+"newStart"+newEnd+"newEnd");
    //         return newStart.before(existingEnd) && newEnd.after(existingStart);
    //     }
    //     return false;
    // });


    // Check if the new assignment overlaps with any existing assignment for the same crew member and pairing
    boolean overlap = assgn.stream().anyMatch(existing -> {
        if (existing.getCrewMemberId().equals(assignPairingInput.getCrewMemberId()) &&
            existing.getPairingId().equals(assignPairingInput.getPairingId())) {
            Date existingStart = parseDate(existing.getAssignmentStartDateTime());
            Date existingEnd = parseDate(existing.getAssignmentEndDateTime());
            Date newStart = parseDate(assignPairingInput.getAssignmentStartDateTime());
            Date newEnd = parseDate(assignPairingInput.getAssignmentEndDateTime());
            return (newStart.before(existingEnd) && newEnd.after(existingStart)) ||
            (newStart.equals(existingEnd) || newEnd.equals(existingStart))||
                   (newStart.after(existingStart) && newStart.before(existingEnd)) ||
                   (newEnd.after(existingStart) && newEnd.before(existingEnd));
        }
        return false;
    });


    if (overlap) {
        return Response.ok(new PairingAssigned("404", "error", "Date overlap detected", List.of())).build();
    }


        if(found){
            return Response.ok(new PairingAssigned("404", "error", "Id Already exist",List.of())).build();
        }



       

        
        // Access the crewMemberId from each AssignPairing object
    //   List<String> list = new ArrayList<>();
    //   list.add( assignPairingInput.getCrewMemberId());
      

       assgn.add(assignPairingInput);

       List<String> as = assgn.stream()
       .filter(x -> x.getId() != null) 
       .map(AssignPairing::getCrewMemberId) 
       .collect(Collectors.toList());

      
    //    System.out.println(assgn);


  
        return Response.ok(new PairingAssigned("200", "success", "Crew added to pairing",as)).build();
        // TODO Auto-generated method stub
    }



    //getById
    @Override
    public Response getPairingById(String id){

        System.out.println("get by id");


        boolean found = assgn.stream()
        .anyMatch(restriction -> restriction.getPairingId().equals(id));

        List<String> pair = assgn.stream()
        .filter(x -> x.getPairingId() .equals(id)) 
        .map(AssignPairing::getCrewMemberId) 
        .collect(Collectors.toList());

        if(found){
            return Response.ok(new PairingByIdResponse("200","success","crewmember get By Id",pair)).build();
        }


        return Response.ok(new PairingByIdResponse("404","error","crewmember not found",List.of())).build();
    }


    //getAll pairing 
    public Response getAllPairing(){


        //for dulicate record
//         Map<String, String> pairingToCrewMap = assgn.stream()
//         .collect(Collectors.groupingBy(
//                 AssignPairing::getPairingId,
//                 Collectors.mapping(AssignPairing::getCrewMemberId, Collectors.joining(", "))
                
//         ));

// List<String> pairingsAndCrew = pairingToCrewMap.entrySet().stream()
//         .map(entry -> entry.getKey() + "------> " + entry.getValue())
//         .collect(Collectors.toList());

// pairingsAndCrew.forEach(System.out::println);




Map<String, Set<String>> pairingToCrewMap = assgn.stream()
                .collect(Collectors.groupingBy(
                        AssignPairing::getPairingId,
                        Collectors.mapping(AssignPairing::getCrewMemberId, Collectors.toSet())
                ));
        
        List<String> pairingsAndCrew = pairingToCrewMap.entrySet().stream()
                .map(entry -> entry.getKey() + "------>" + String.join(", ", entry.getValue()))
                .collect(Collectors.toList());

        pairingsAndCrew.forEach(System.out::println);



//for unique record
//         Map<String, Set<String>> pairingToCrewMap = assgn.stream()
//         .collect(Collectors.groupingBy(
//                 AssignPairing::getPairingId,
//                 Collectors.mapping(AssignPairing::getCrewMemberId, Collectors.toSet())
//         ));

// List<String> pairingsAndCrew = pairingToCrewMap.entrySet().stream()
//         .map(entry -> entry.getKey() + "------>" + String.join(", ", entry.getValue()))
//         .collect(Collectors.toList());
//         pairingsAndCrew.forEach(System.out::println);



        return Response.ok(new PairingByIdResponse("200","success","crewmember are ",pairingsAndCrew)).build();
    }


//getAllRestriction
    // public Response getAllRestriction( ) {
    //     return Response.ok(new PairingByIdResponse("200","success","crewmember are ",List.of())).build();
    // }


    




// //pairing creation
//     public Response createPairing( PairingCreation pairingCreation){

//         boolean found = pairCreation.stream()
//         .anyMatch(restriction -> restriction.getId().equals(pairingCreation.getId()));

//         if(found){
//             return Response.ok(new PairingCreationResponse("404","error","already exist ",pairingCreation)).build();

//         }

//         pairCreation.add(pairingCreation);
//         System.out.println(pairingCreation);
        
//         return Response.ok(new PairingCreationResponse("200","success","pairing creation  are ",pairingCreation)).build();
//     }

// //get all pairingcreation
//     public Response getPairing(){

//         List<PairingCreation> as = pairCreation.stream()
//         .filter(x -> x.getId() != null)  
//         .collect(Collectors.toList());

//         if(as.isEmpty()){
//             return Response.status(Response.Status.NOT_FOUND).entity("the list is empty ").build();
//         }
//         return Response.status(Response.Status.FOUND).entity(as).build();
//     }



//     //get pairing cration by id
//     public Response getCreationPairingById(String id )
    
//     {
    

//         PairingCreation as = pairCreation.stream()
//         .filter(x -> x.getId().equals(id))
//         .findFirst()
//         .orElse(null);

//         if (as == null) {
//             return Response.status(Response.Status.NOT_FOUND)
//                     .entity("No PairingCreation found with the provided ID: " + id)
//                     .build();
//         }
        


//         return Response.ok(new PairingCreationResponse("200","success"," pair creation by Id ",as)).build();


    
//     }


//     //update pair creation
//     public Response updateCreationPairing(String id ,PairingCreation pairingCreation){

//         PairingCreation as = pairCreation.stream()
//         .filter(x -> x.getId().equals(id))
//         .findFirst()
//         .orElse(null);

//         if (as == null) {
//             return Response.status(Response.Status.NOT_FOUND)
//                     .entity("No PairingCreation found with the provided ID: " + id)
//                     .build();
//         }
        
//         as.setPairingCode(pairingCreation.getPairingCode());
//         as.setStartDateTime(pairingCreation.getStartDateTime());
//         as.setEndDateTime(pairingCreation.getEndDateTime());

//         return Response.ok(new PairingCreationResponse("200","success"," pair update successfully ",as)).build();
//     }

// //delete pair creation
//     public Response deleteCreationPairing(String id ){

//         boolean found = pairCreation.stream()
//         .anyMatch(pair -> pair.getId().equals(id));

//     if (found) {
//        // Remove the object with the given id from the crewRestriction collection
//        pairCreation.removeIf(pair -> pair.getId().equals(id));
//     //   System.out.println(crewRestriction);

//       return Response.ok(new DeleteRestrictionResponse("200", "success", "Crew restriction '" + id + "' deleted for pairing")).build();

//     }

//     return Response.ok("Not Found").build();
//     }



}
