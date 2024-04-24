package com.example.ibs.request;

import lombok.*;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightLegInfo {


    private String flightLegInfoID;
    private String carrierCode;
    private String flightNumber;
    private String flightDate;
    private String departureAirport;
    private String arrivalAirport;
    private String flightType;
    private String aircraftRegistration;
    private String aircraftSubtype;
    private String legSequenceNumber;



}
