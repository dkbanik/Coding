package lowleveldesign.atm;

public class WithdrawState extends ATMState{

    public void withdraw(ATMMachine machine, Card card, int amount){
        if(machine.getTotalAmount() < amount){
            System.out.println("Not enough money in atm");
            machine.setAtmState(new IdleState());
        }
        else if(card.getUser().getBankAccount().getBalance() < amount){
            System.out.println("Not enough money in account");
            machine.setAtmState(new IdleState());
        }
        else {
            
        }

    }
}
