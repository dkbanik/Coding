package lowleveldesign.atm;

public class SelectOperationState extends ATMState{
    @Override
    public void selectOperation(ATMMachine machine, TransactionType transactionType){
        switch (transactionType){
            case PIN_CHECK :
                System.out.println("Pin checked");
                exit(machine);
        }

    }
}
