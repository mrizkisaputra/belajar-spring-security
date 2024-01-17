package com.mrizkisaputra.model.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Data
public class ApiSuccessResponse<T> {
    private HttpStatus status;

    private String message;

    private List<T> data;

    private PagingResponse paging;

    public ApiSuccessResponse() { }

    public ApiSuccessResponse(HttpStatus status) {
        this.status = status;
    }

    public ApiSuccessResponse(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

    public ApiSuccessResponse(HttpStatus status, String message, List<T> data) {
        this(status, message);
        this.data = data;
    }
    
    public ApiSuccessResponse(HttpStatus status, String message, List<T> data, PagingResponse paging) {
        this(status, message, data);
        this.paging = paging;
    }
}
