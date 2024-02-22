package wrap.lowleveldesign.atm;

public class ATMMachine {
    private int totalAmount;
    private ATMState atmState;
    private int noOf2000notes;
    private int noOf1000notes;
    private int noOf500notes;

    public ATMMachine(int totalAmount, ATMState atmState, int noOf2000notes, int noOf1000notes, int noOf500notes) {
        this.totalAmount = totalAmount;
        this.atmState = atmState;
        this.noOf2000notes = noOf2000notes;
        this.noOf1000notes = noOf1000notes;
        this.noOf500notes = noOf500notes;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public int getNoOf2000notes() {
        return noOf2000notes;
    }

    public int getNoOf1000notes() {
        return noOf1000notes;
    }

    public int getNoOf500notes() {
        return noOf500notes;
    }
    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }
}
