package lowleveldesign.atm;

public class InsertCardState extends ATMState{
    @Override
    public void insertCard(ATMMachine machine, Card card){
        System.out.println("Card Inserted...Enter PIN");
    }
    @Override
    public void authenticateCard(ATMMachine atmMachine, Card card, int pin){
        if(card.getPin() != pin){
            System.out.println("Incorrect Pin");
            exit(atmMachine);
        }else{
            atmMachine.setAtmState(new SelectOperationState());
        }
    }
    @Override
    public void exit(ATMMachine atmMachine){
        System.out.println("Transaction complete");
        returnCard(atmMachine);
    }
    public void returnCard(ATMMachine atmMachine){
        System.out.println("Take out card");
        atmMachine.setAtmState(new IdleState());
    }

}
