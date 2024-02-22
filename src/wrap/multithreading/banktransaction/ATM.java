package wrap.multithreading.banktransaction;

public interface ATM extends Runnable {
    void moneyToWithdraw(int money);

}
