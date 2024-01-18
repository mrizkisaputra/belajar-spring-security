package com.mrizkisaputra.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiErrorResponse<T extends ApiSubErrorResponse> {
    private HttpStatus status;

    private String message;

    private String debugMessage;

    private List<T> subErrors;


}
