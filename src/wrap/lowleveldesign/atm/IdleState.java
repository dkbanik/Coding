package wrap.lowleveldesign.atm;

public class IdleState extends ATMState{
    @Override
    public void idleState(ATMMachine atmMachine){
        System.out.println("Please enter card...");
        atmMachine.setAtmState(new InsertCardState());
    }
}
