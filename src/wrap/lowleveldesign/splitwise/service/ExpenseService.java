package wrap.lowleveldesign.splitwise.service;



import wrap.lowleveldesign.splitwise.model.Expense;
import wrap.lowleveldesign.splitwise.model.SplitType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {
    public Map<Integer, Expense> expenseMap = new HashMap<>();

    UserService userService;

    public ExpenseService(UserService userService) {
        this.userService = userService;
    }

    public List<Expense> createExpenses(){
        List<Expense> expenseList = new ArrayList<>();

        Expense expense1 = new Expense(1, "cab", 3000.0, userService.getUser(1), SplitType.EQUAL);
        Expense expense2 = new Expense(2, "food", 6000.0, userService.getUser(2), SplitType.EQUAL);
        Expense expense3 = new Expense(3, "stay", 9000.0, userService.getUser(3), SplitType.EQUAL);
        expenseMap.put(expense1.id,expense1);
        expenseMap.put(expense2.id,expense2);
        expenseMap.put(expense3.id,expense3);
        expenseList.add(expense1);expenseList.add(expense2);
        expenseList.add(expense3);
        return expenseList;
    }

    public void splitExpense(int expenseId){
        Expense expense = expenseMap.get(expenseId);
    }

    public Expense getExpense(int id){
        return expenseMap.get(id);
    }

}
