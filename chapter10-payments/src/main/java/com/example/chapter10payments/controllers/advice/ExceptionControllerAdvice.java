package com.example.chapter10payments.controllers.advice;

import com.example.chapter10payments.exceptions.NotEnoughMoneyException;
import com.example.chapter10payments.model.ErrorDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<?> handleNotEnoughMoneyException(NotEnoughMoneyException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

}
