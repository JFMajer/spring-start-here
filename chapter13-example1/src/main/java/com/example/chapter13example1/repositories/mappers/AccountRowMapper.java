package com.example.chapter13example1.repositories.mappers;

import com.example.chapter13example1.models.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setName(rs.getString("name"));
        account.setAmount(rs.getBigDecimal("amount"));
        return account;
    }
}
