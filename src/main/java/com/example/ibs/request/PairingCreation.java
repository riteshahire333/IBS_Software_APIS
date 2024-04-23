package com.example.ibs.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PairingCreation {

    private String id;
    private String pairingCode;
    private String startDateTime;
    private String endDateTime;
    private String fleet;
    private String base;
    private String crewType;

}
