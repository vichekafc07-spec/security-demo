package com.library.spring_security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse<?>> handleNotFoundException(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(APIResponse.error(ex.getMessage(),HttpStatus.NOT_FOUND));
    }

    // handle validation DTO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        // get errors key
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((item)->{
            errors.put(item.getField(),item.getDefaultMessage());
        });
        Map<String,Object> res = new HashMap<>();
        res.put("success",false);
        res.put("code",HttpStatus.BAD_REQUEST.value()); // 400
        res.put("message","Validation Failed");
        res.put("data",null);
        res.put("errors",errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<?>> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(APIResponse.error(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
