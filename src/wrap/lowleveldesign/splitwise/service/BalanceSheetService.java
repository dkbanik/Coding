package wrap.lowleveldesign.splitwise.service;


import wrap.lowleveldesign.splitwise.model.Expense;
import wrap.lowleveldesign.splitwise.model.SplitwiseUser;

import java.util.Map;

public class BalanceSheetService {

    public void updateUserBalanceSheet(Expense expense){
        Map<SplitwiseUser, Double> userExpenseMap = expense.expenseToUserBalanceMap.get(expense.id);
        SplitwiseUser paidBy = expense.paidBy;
        for(Map.Entry<SplitwiseUser, Double> entry : userExpenseMap.entrySet()){
            SplitwiseUser user = entry.getKey();
            Double amount = entry.getValue();
            // paidby user
            if(amount > 0){
                paidBy.balanceSheet.totalAmountPaid+=expense.totalExpense;
            }else{
                paidBy.balanceSheet.getBack+=amount;
                user.balanceSheet.giveBack-=amount;
                user.balanceSheet.otherUserBalance.put(paidBy, user.balanceSheet.otherUserBalance.getOrDefault(paidBy, 0.0)+amount);
                paidBy.balanceSheet.otherUserBalance.put(user, paidBy.balanceSheet.otherUserBalance.getOrDefault(user, 0.0)-amount);

                user.balanceSheet.netAmount = user.balanceSheet.totalAmountPaid+user.balanceSheet.giveBack-user.balanceSheet.getBack;
                paidBy.balanceSheet.netAmount = paidBy.balanceSheet.totalAmountPaid+paidBy.balanceSheet.giveBack-paidBy.balanceSheet.getBack;
            }

        }
    }
}
