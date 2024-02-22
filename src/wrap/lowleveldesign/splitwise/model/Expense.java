package wrap.lowleveldesign.splitwise.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expense {
    public final int id;
    public final String name;
    public final Double totalExpense;
    public final SplitwiseUser paidBy;
    public final SplitType splitType;
    public boolean splitDone = false;
    public Map<Integer, Map<SplitwiseUser, Double>> expenseToUserBalanceMap = new HashMap<>();

    public Expense(int id, String name, Double totalExpense, SplitwiseUser paidBy, SplitType splitType) {
        this.id = id;
        this.name = name;
        this.totalExpense = totalExpense;
        this.paidBy = paidBy;
        this.splitType = splitType;
        expenseToUserBalanceMap.put(id, new HashMap<>());
    }

    public void splitExpense(Expense expense, List<SplitwiseUser> users){
        if(!expense.splitDone){
            int size = users.size();
            Double shareAmount = expense.totalExpense/size;
            Map<SplitwiseUser, Double> userToExpenseMap = expense.expenseToUserBalanceMap.get(expense.id);
            userToExpenseMap.put(expense.paidBy, expense.totalExpense);
            for(SplitwiseUser user : users){
                userToExpenseMap.put(user, userToExpenseMap.getOrDefault(user,0.0) - shareAmount);
            }
            expense.splitDone = true;
        }

    }
}
