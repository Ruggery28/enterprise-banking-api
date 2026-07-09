package com.ruggery.bank;

import com.ruggery.bank.model.CheckingAccount;
import com.ruggery.bank.model.SavingsAccount;
import com.ruggery.bank.model.User;
import com.ruggery.bank.repository.AccountRepository;
import com.ruggery.bank.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(UserRepository userRepository, AccountRepository accountRepository) {
        return args -> {
            System.out.println("Database Check: Initializing demo accounts...");

            // 1. Only seed data if the database is currently empty!
            if (userRepository.count() == 0) {

                // 2. Create the customer object (Pass null for ID so MySQL generates it automatically)
                User sampleUser = new User(null, "Ruggery", "Alves", "ruggery@email.com");

                // 3. Save the user first! Your UserRepository is officially read here!
                User savedUser = userRepository.save(sampleUser);
                System.out.println("Customer registered with ID: " + savedUser.getId());

                // 4. Create the accounts and link them to the newly saved customer record
                CheckingAccount checking = new CheckingAccount("001", 100.0, savedUser, 500.0);
                SavingsAccount savings = new SavingsAccount("002", 50.0, savedUser, 0.02);

                // 5. Save the accounts to the live MySQL accounts table
                accountRepository.save(checking);
                accountRepository.save(savings);

                System.out.println("Live MySQL database successfully seeded with accounts '001' and '002'.");
            } else {
                System.out.println("Records already present in MySQL. Skipping data seeding step.");
            }
        };
    }
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
