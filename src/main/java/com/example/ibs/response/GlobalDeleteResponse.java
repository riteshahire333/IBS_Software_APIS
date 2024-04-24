package com.example.ibs.response;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalDeleteResponse {

    @NotNull(message="returnCode can not be NotNull")
    private String returnCode;
    @NotNull(message="status can not be NotNull")
    private String status;
    @NotNull(message="message can not be NotNull")
    private String message;
}
