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
public class CrewCreation {

    private String id;
    private String crew_Identifier;
    private String first_name;
    private String last_name;
    private String crewType;
    private String gender;
    private String birth_country;
    private String dob;
    private String joining_date;


}
