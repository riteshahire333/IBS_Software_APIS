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
public class CrewRestrictionAdd {
    private String id;
    private String crewmemberId;
    private String restriction_type;
    private String fromDate;
    private String toDate;
    private String restrcitedCrewId;
}

