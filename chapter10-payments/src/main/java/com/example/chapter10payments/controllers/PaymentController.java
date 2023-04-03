package com.example.chapter10payments.controllers;

import com.example.chapter10payments.exceptions.NotEnoughMoneyException;
import com.example.chapter10payments.model.PaymentDetails;
import com.example.chapter10payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.chapter10payments.model.ErrorDetails;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetails paymentDetails) {

        logger.info("Received payment " + paymentDetails.getAmount());

        if (paymentDetails.getAmount() < 1000) {
            throw new NotEnoughMoneyException();
        }

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
