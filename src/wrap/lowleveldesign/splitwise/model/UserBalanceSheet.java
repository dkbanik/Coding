package wrap.lowleveldesign.splitwise.model;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {
    public Double netAmount = 0.0;
    public Double totalAmountPaid = 0.0;
    public Double getBack = 0.0;
    public Double giveBack = 0.0;

    public Map<SplitwiseUser, Double> otherUserBalance = new HashMap<>();

    @Override
    public String toString() {
        return "UserBalanceSheet{" +
                "netAmount=" + netAmount +
                ", totalAmountPaid=" + totalAmountPaid +
                ", getBack=" + getBack +
                ", giveBack=" + giveBack +
                ", otherUserBalance=" + otherUserBalance +
                '}';
    }
}
