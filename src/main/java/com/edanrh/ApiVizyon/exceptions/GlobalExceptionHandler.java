package com.edanrh.ApiVizyon.exceptions;

import com.edanrh.ApiVizyon.common.StandardizedApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
//@RestController
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BussinesRuleException.class)
    public ResponseEntity<StandardizedApiExceptionResponse> handleBusinessRuleException(BussinesRuleException ex) {
        StandardizedApiExceptionResponse response = new StandardizedApiExceptionResponse("Business error",ex.getCode(),ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(ContentNullException.class)
    public ResponseEntity<StandardizedApiExceptionResponse> handleContentNullException(ContentNullException ex) {
        StandardizedApiExceptionResponse response = new StandardizedApiExceptionResponse("Without content error", ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardizedApiExceptionResponse> handleNotFoundException(NotFoundException ex) {
        StandardizedApiExceptionResponse response = new StandardizedApiExceptionResponse("Not found error", ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateCreationException.class)
    public ResponseEntity<StandardizedApiExceptionResponse> handleDuplicationCreationException(DuplicateCreationException ex) {
        StandardizedApiExceptionResponse response = new StandardizedApiExceptionResponse("Duplicate creation error", ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ReferencedEntityException.class)
    public ResponseEntity<StandardizedApiExceptionResponse> handleReferencedEntityException(ReferencedEntityException ex) {
        StandardizedApiExceptionResponse response = new StandardizedApiExceptionResponse("Referenced entity exception", ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(QuantityEntityException.class)
    public ResponseEntity<StandardizedApiExceptionResponse> handleQuantityEntityException(QuantityEntityException ex) {
        StandardizedApiExceptionResponse response = new StandardizedApiExceptionResponse("Quantity entities error", ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<StandardizedApiExceptionResponse> handleUnauthorizedException(UnauthorizedException ex) {
        StandardizedApiExceptionResponse response = new StandardizedApiExceptionResponse("Unauthorized error", ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
