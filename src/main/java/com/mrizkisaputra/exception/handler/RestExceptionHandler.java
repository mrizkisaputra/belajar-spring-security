package com.mrizkisaputra.exception.handler;

import com.mrizkisaputra.model.response.ApiErrorResponse;
import com.mrizkisaputra.model.response.ApiSubErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> responseStatusException(ResponseStatusException error) {
        HttpStatus status = (HttpStatus) error.getStatusCode();
        ApiErrorResponse<ApiSubErrorResponse> apiErrorResponse = new ApiErrorResponse<>(
                status,
                error.getReason(),
                error,
                null
        );

        return buildResponseEntity(apiErrorResponse);
    }

    private <T extends ApiSubErrorResponse> ResponseEntity<Object> buildResponseEntity(ApiErrorResponse<T> apiErrorResponse) {
        return new ResponseEntity<>(apiErrorResponse, apiErrorResponse.getStatus());
    }
}
