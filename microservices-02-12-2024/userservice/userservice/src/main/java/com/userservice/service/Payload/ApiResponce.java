package com.userservice.service.Payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponce {

    private String message;
    private boolean success;
    private HttpStatus status;

}
