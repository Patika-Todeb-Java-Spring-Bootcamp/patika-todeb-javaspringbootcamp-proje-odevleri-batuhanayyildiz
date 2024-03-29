package com.todeb.batuhanayyildiz.libraryautomationapplication.exception.handler;


import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.CustomJwtException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GenericExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map> handleNotFoundException(NotFoundException exception){
        Map<String,String> response = new HashMap<>();
        response.put("error_message",exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }

    @ExceptionHandler(CustomJwtException.class)
    public ResponseEntity<Map> handleCustomJwtException(CustomJwtException exception){
        Map<String,String> response =new HashMap<>();
        response.put("error_message", exception.getMessage());
        response.put("error_status", exception.getHttpStatus().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map> handleAccessDeniedException(AccessDeniedException exception){
        Map<String,String> response = new HashMap<>();
        response.put("error_message",exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map> handleException(Exception exception){
        Map<String,String> response =new HashMap<>();
        response.put("error_message",exception.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        
    }

}
