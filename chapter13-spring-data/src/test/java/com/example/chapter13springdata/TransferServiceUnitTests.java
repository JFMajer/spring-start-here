package com.example.chapter13springdata;

import com.example.chapter13springdata.models.Account;
import com.example.chapter13springdata.repositories.AccountRepository;
import com.example.chapter13springdata.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class TransferServiceUnitTests {

    @DisplayName("test the amount that is transferred from one account to another")
    @Test
    public void moneyTransferHappyFlow() throws AccountNotFoundException {
        AccountRepository accountRepository = mock(AccountRepository.class);
        TransferService transferService = new TransferService(accountRepository);

        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        transferService.transferMoney(sender.getId(), receiver.getId(), new BigDecimal(100));

        verify(accountRepository).changeAmount(sender.getId(), new BigDecimal(900));

        verify(accountRepository).changeAmount(receiver.getId(), new BigDecimal(1100));

    }
}
