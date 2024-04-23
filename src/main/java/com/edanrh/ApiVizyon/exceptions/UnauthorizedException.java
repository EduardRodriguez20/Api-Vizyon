package com.edanrh.ApiVizyon.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class UnauthorizedException extends Exception {

    private String code;
    private HttpStatus httpStatus;

    public UnauthorizedException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
