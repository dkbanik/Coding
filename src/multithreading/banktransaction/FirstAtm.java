package multithreading.banktransaction;

import javax.activity.InvalidActivityException;

public class FirstAtm implements ATM{

    private Bank bank;
    private int money;

    public FirstAtm(Bank bank) {
        this.bank = bank;
    }

    public void moneyToWithdraw(int money){
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
