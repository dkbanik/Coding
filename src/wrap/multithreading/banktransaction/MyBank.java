package wrap.multithreading.banktransaction;

import javax.activity.InvalidActivityException;

public class MyBank implements Bank{

    private int money = 0;

    @Override
    public void deposit(int money) {
        this.money += money;
    }

    @Override
    public void withdraw(int money) throws InvalidActivityException {
        if(checkBalance() < money) throw new InvalidActivityException();
        else this.money-=money;
    }

    @Override
    public int checkBalance() {
        return this.money;
    }
}
