package com.example.ibs.response;

import java.util.List;

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
public class PairingAssigned{

    @NotNull(message="returnCode can not be NotNull")
    private String returnCode;
    @NotNull(message="status can not be NotNull")
    private String status;
    @NotNull(message="message can not be NotNull")
    private String message;
    @NotNull(message="crewMembersId can not be NotNull")
    private List<String> crewMembersId;
}
