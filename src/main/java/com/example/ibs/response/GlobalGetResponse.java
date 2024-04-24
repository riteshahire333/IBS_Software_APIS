package com.example.ibs.response;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalGetResponse {

    @NotNull(message="returnCode can not be NotNull")
    private String returnCode;

    @NotNull(message="status can not be NotNull")
    private String status;

    @NotNull(message="message can not be NotNull")
    private String message;

    @NotNull(message="crewMembersId can not be NotNull")
    private List<Object> obj;
}
