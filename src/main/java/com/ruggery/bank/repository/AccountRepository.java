package com.ruggery.bank.repository;
import org.springframework.stereotype.Repository;
import com.ruggery.bank.model.Account;


@Repository
public class AccountRepository {

    private final java.util.Map<String, Account> database = new java.util.HashMap<>();

    public void save(Account account) {
        String accountNumber = account.getAccountNumber();
        database.put(accountNumber, account);
    }

    public Account findByAccountNumber(String accountNumber) {
        //the method returns null if it cant find an accountNumber.
        return database.get(accountNumber);
    }

    public void deleteByAccountNumber(String accountNumber) {
        database.remove(accountNumber);
    }

}
