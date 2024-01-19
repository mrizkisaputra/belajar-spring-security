package com.mrizkisaputra.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Data
public class ApiErrorResponse<T extends ApiSubErrorResponse> {
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy : HH:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private String debugMessage;

    private List<T> subErrors;

    public ApiErrorResponse() {
        this.timestamp = LocalDateTime.now(ZoneId.systemDefault());
    }

    public ApiErrorResponse(HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiErrorResponse(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

    public ApiErrorResponse(HttpStatus status, String message, Throwable debugMessage) {
        this(status, message);
        this.debugMessage = debugMessage.getLocalizedMessage();
    }

    public ApiErrorResponse(HttpStatus status, String message, Throwable debugMessage, List<T> subError) {
        this(status, message, debugMessage);
        this.subErrors = subError;
    }
}
