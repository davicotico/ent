package com.davidticona.ent.handler;

import com.davidticona.ent.exceptions.ObjectNotValidException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }
    
    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<?> handleException(ObjectNotValidException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getErrorMessages());
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleException(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
}
