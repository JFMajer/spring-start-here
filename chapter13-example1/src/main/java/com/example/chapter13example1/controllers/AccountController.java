package com.example.chapter13example1.controllers;

import com.example.chapter13example1.models.Account;
import com.example.chapter13example1.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.chapter13example1.dto.TransferRequest;

import java.util.List;


@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/accounts")
    public List<Account> findAllAccounts() {
        return transferService.findAllAccounts();
    }
    
    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
    ) {
        transferService.transferMoney(
                transferRequest.getIdSender(),
                transferRequest.getIdReceiver(),
                transferRequest.getAmount()
        );
    }

}
