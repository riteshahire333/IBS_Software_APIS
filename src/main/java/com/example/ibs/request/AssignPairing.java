package com.example.ibs.request;

import java.util.List;
import java.util.Date;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

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
public class AssignPairing{

    @NotNull(message="id can not be NotNull")
    private String id;
    @NotNull(message="crewMemberId can not be NotNull")
    private String crewMemberId;
    @NotNull(message="allocationType can not be NotNull")
    private String allocationType;
    @NotNull(message="assignmentStartDateTime can not be NotNull")
    private String assignmentStartDateTime;
    @NotNull(message="assignmentEndDateTime can not be NotNull")
    private String assignmentEndDateTime;
    @NotNull(message="pairingId can not be NotNull")
    private String pairingId;
    @NotNull(message="activityId can not be NotNull")
    private String activityId;
}
