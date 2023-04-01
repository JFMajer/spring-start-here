package com.example.chapter10payments.service;

import com.example.chapter10payments.exceptions.NotEnoughMoneyException;
import com.example.chapter10payments.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
