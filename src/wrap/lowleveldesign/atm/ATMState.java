package wrap.lowleveldesign.atm;

public abstract class ATMState {

    public void idleState(ATMMachine atmMachine){
        System.out.println("Something went wrong");
    }

    public void insertCard(ATMMachine machine, Card card){
        System.out.println("Something went wrong");
    }
    public void authenticateCard(ATMMachine atmMachine, Card card, int pin){
        System.out.println("Something went wrong");
    }
    public void selectOperation(ATMMachine machine, TransactionType transactionType){
        System.out.println("Something went wrong");
    }
    public void withdraw(ATMMachine machine, Card card, int amount){
        System.out.println("Something went wrong");
    }
    public void deposit(ATMMachine atmMachine, Card card){
        System.out.println("Something went wrong");
    }
    public void pinCheck(ATMMachine atmMachine, Card card){
        System.out.println("Something went wrong");
    }
    public void exit(ATMMachine atmMachine){
        System.out.println("Something went wrong");
    }
    public void returnCard(ATMMachine atmMachine){
        System.out.println("Something went wrong");
    }
}
