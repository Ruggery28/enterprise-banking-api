//import com.ruggery.bank.exception.InsufficientFundsException;
//import com.ruggery.bank.model.CheckingAccount;
//import com.ruggery.bank.model.SavingsAccount;
//import com.ruggery.bank.model.User;
//import com.ruggery.bank.repository.AccountRepository;
//import com.ruggery.bank.repository.TransactionRepository;
//import com.ruggery.bank.service.BankService;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        AccountRepository accountRepository = new AccountRepository();
//        TransactionRepository transactionRepository = new TransactionRepository();
//
//        User user = new User(1L, "Ruggery", "Alves", "ruggery@email.com");
//        CheckingAccount cAccount = new CheckingAccount("001", 100, user, 500);
//        SavingsAccount sAccount = new SavingsAccount("002", 50, user, 0.2);
//        accountRepository.save(cAccount);
//        accountRepository.save(sAccount);
//
//        //Test 01
//        BankService bankService = new BankService(accountRepository, transactionRepository);
//        bankService.transfer("001", "002", 50);
//        System.out.println("Checking Balance in DB: " + accountRepository.findByAccountNumber("001").getBalance());
//        System.out.println("Savings Balance in DB: " + accountRepository.findByAccountNumber("002").getBalance());
//
//        //Test 02
//        try {
//            bankService.transfer("001", "002", 1000);
//            System.out.println("Checking Balance in DB: " + accountRepository.findByAccountNumber("001").getBalance());
//            System.out.println("Savings Balance in DB: " + accountRepository.findByAccountNumber("002").getBalance());
//
//        } catch (InsufficientFundsException e) {
//            System.out.println("Successfully caught expected error: " + e.getMessage());
//        }
//    }
//}
