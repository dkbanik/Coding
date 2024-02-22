package wrap.multithreading.banktransaction;

import javax.activity.InvalidActivityException;

public class SecondAtm implements ATM{

    private Bank bank;
    private int money;

    public SecondAtm(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void moneyToWithdraw(int money) {
        this.money = money;
    }

    @Override
    public void run() {
        try {
            bank.withdraw(this.money);
            System.out.println("Bank balance is: "+bank.checkBalance());
        } catch (InvalidActivityException e) {
            System.out.println("Bank is out of money");
        }
    }


}
