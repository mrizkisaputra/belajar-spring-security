package com.mrizkisaputra.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class ApiSubErrorResponse {
    private String object;

    private String field;

    private String message;

    public ApiSubErrorResponse(String object) {
        this.object = object;
    }

    public ApiSubErrorResponse(String object, String field) {
        this(object);
        this.field = field;
    }

    public ApiSubErrorResponse(String object, String field, String message) {
        this(object, field);
        this.message = message;
    }
}
