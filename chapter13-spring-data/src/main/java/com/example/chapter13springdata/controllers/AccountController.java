package com.example.chapter13springdata.controllers;

import com.example.chapter13springdata.dto.AddRequest;
import com.example.chapter13springdata.dto.TransferRequest;
import com.example.chapter13springdata.services.TransferService;
import org.springframework.web.bind.annotation.*;
import com.example.chapter13springdata.models.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
    ) throws AccountNotFoundException {
        transferService.transferMoney(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name != null) {
            return transferService.findAccountsByName(name);
        }
        return transferService.getAllAccounts();
    }

    // add money to account
    @PostMapping("/accounts/{id}/add")
    public void addMoney(
            @PathVariable long id,
            @RequestBody AddRequest addRequest
    ) throws AccountNotFoundException {
        transferService.addMoney(
                id,
                addRequest.getAmount()
        );
    }

}
