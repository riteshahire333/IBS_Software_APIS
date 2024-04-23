package com.example.ibs.response;


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
public class CrewRestrictionUpdateResponse {
    private String returnCode;
    private String status;
    private String message;
    private String restrictionId;
}
