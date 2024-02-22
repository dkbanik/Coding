package wrap.lowleveldesign.atm;

public class User {
    private BankAccount bankAccount;

    public User(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
