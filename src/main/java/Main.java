import com.ruggery.bank.exception.InsufficientFundsException;
import com.ruggery.bank.model.CheckingAccount;
import com.ruggery.bank.model.SavingsAccount;
import com.ruggery.bank.model.User;
import com.ruggery.bank.service.BankService;

public class Main {

    public static void main(String[] args) {

        User user = new User(1L, "Ruggery", "Alves", "ruggery@email.com");

        CheckingAccount cAccount = new CheckingAccount("001", 100, user, 500);

        SavingsAccount sAccount = new SavingsAccount("002", 50, user, 0.2);

        //Test 01
        BankService bankService = new BankService();
        bankService.transfer(cAccount, sAccount, 50);
        System.out.println(cAccount.getBalance());
        System.out.println(sAccount.getBalance());

        try {
            BankService bankService1 = new BankService();
            bankService1.transfer(cAccount, sAccount, 1000);
            System.out.println(cAccount.getBalance());
            System.out.println(sAccount.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Successfully caught expected error: " + e.getMessage());
        }
    }
}
