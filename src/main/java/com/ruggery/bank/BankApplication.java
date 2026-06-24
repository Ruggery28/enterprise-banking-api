package com.ruggery.bank;

import com.ruggery.bank.model.CheckingAccount;
import com.ruggery.bank.model.SavingsAccount;
import com.ruggery.bank.model.User;
import com.ruggery.bank.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

//    @Bean // Tells Spring to execute this method automatically at startup
//    public CommandLineRunner demoData(AccountRepository accountRepository) {
//        return args -> {
//            System.out.println("Spring Boot Startup: Seeding demo accounts into the database...");
//
//            // Create a mock user
//            User sampleUser = new User(1L, "Ruggery", "Alves", "ruggery@email.com");
//
//            // Create your classic testing accounts
//            CheckingAccount checking = new CheckingAccount("001", 100.0, sampleUser, 500.0);
//            SavingsAccount savings = new SavingsAccount("002", 50.0, sampleUser, 0.02);
//
//            // Save them to your in-memory repository
//            accountRepository.save(checking);
//            accountRepository.save(savings);
//
//            System.out.println("Database successfully seeded! Accounts '001' and '002' are ready.");
//        };
//    }
}