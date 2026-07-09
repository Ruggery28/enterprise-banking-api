package com.ruggery.bank.repository;

import com.ruggery.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// We tell JpaRepository we are managing the 'Account' entity, and its Primary Key is a 'String' (the account number)
public interface AccountRepository extends JpaRepository<Account, String> {

    // Spring Data JPA reads this method name and automatically writes the custom SQL query for you!
    Account findByAccountNumber(String accountNumber);
}