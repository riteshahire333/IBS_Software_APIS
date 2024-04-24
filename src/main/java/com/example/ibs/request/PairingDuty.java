package com.example.ibs.request;

import lombok.*;


@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PairingDuty {


    private String pairingDutyId;

    private String pairingId;

    private String departureStation;

    private String arrivalStation;

    private String plannedStartDateTime;

    private String plannedEndDateTime;

    private String flightTimeMins;

    private String dutyTimeMins;

    private String reportTravelTimeMins;

    private String debriefTravelTimeMins;

    private String dutySequenceNumber;
}
