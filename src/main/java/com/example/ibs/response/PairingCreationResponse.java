package com.example.ibs.response;

import com.example.ibs.request.PairingCreation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PairingCreationResponse {


    @NotNull(message="returnCode can not be NotNull")
    private String returnCode;
    @NotNull(message="status can not be NotNull")
    private String status;
    @NotNull(message="message can not be NotNull")
    private String message;
    @NotNull(message="crewMembersId can not be NotNull")
    private PairingCreation pairingCreation;

}
