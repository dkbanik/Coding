package wrap.multithreading.banktransaction;

import javax.activity.InvalidActivityException;

public interface Bank {
    void deposit(int money);
    void withdraw(int money) throws InvalidActivityException;
    int checkBalance();
}
