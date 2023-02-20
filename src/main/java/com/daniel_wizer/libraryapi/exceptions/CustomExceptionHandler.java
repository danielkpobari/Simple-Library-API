package com.daniel_wizer.libraryapi.exceptions;

import com.daniel_wizer.libraryapi.payload.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exception){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(prepareErrorJSON(status, exception), status);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException exception){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(prepareErrorJSON(status, exception), status);
    }


    public static Response prepareErrorJSON(HttpStatus status, Exception ex) {
        Response response = new Response();
        try {
            response.setMessage(ex.getMessage());
            response.setStatus_code(status.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}