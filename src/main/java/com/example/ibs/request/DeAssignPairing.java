package com.example.ibs.request;

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
public class DeAssignPairing{

    @NotNull(message="crewMemberId can not be NotNull")
    private String crewMemberId;
    @NotNull(message="pairingId can not be NotNull")
    private String pairingId;
}
