package com.compasso.challengeapi.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {

    private Integer    status_code;
    private String     message;

}
