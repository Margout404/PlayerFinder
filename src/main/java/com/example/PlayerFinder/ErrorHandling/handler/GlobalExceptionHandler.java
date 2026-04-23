package com.example.PlayerFinder.ErrorHandling.handler;


import com.example.PlayerFinder.ErrorHandling.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyApplied(AlreadyAppliedException exception){
        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                400,
                LocalDateTime.now()
        );

        return ResponseEntity.badRequest().body(error);
    }
}
