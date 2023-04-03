package com.example.chapter111.controllers;

import com.example.chapter111.models.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.example.chapter111.proxy.PaymentProxy;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping ("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
    String requestId = UUID.randomUUID().toString();
    return paymentProxy.createPayment(requestId, payment);
    }
}
