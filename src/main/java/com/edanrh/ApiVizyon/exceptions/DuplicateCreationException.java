package com.edanrh.ApiVizyon.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class DuplicateCreationException extends Exception {

    private String code;
    private HttpStatus httpStatus;

    public DuplicateCreationException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public DuplicateCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
