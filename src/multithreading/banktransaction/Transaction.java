package multithreading.banktransaction;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Transaction {
    public static void main(String[] args) {
        Bank bank = new MyBank();
        bank.deposit(1000);
        System.out.println("Balance is "+bank.checkBalance());
        ATM firstAtm = new FirstAtm(bank);
        ATM secondAtm = new SecondAtm(bank);

        firstAtm.moneyToWithdraw(500);
        secondAtm.moneyToWithdraw(600);

        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(firstAtm);
        executor.execute(secondAtm);

    }
}
