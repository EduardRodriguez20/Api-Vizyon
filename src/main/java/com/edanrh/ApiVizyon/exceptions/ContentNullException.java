package com.edanrh.ApiVizyon.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContentNullException extends Exception{
    private String code;
    private HttpStatus httpStatus;

    public ContentNullException(String code, String message, HttpStatus httpStatus){
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ContentNullException(String message, Throwable cause){
        super(message, cause);
    }
}
