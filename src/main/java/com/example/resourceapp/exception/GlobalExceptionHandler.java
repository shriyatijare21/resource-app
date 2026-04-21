package com.example.resourceapp.exception;

// Thrown when validation (@Valid) fails
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;	
import java.util.Map;

// Applies to ALL controllers (global error handler)
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles validation errors automatically
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {

        // Map to store field → error message
        Map<String, String> errors = new HashMap<>();

        // Loop through all validation errors
        ex.getBindingResult().getFieldErrors().forEach(error ->
            // Put field name and its error message
            errors.put(error.getField(), error.getDefaultMessage())
        );

        // Return 400 Bad Request with error details
        return ResponseEntity.badRequest().body(errors);
    }
}
