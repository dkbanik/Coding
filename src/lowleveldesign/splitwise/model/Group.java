package lowleveldesign.splitwise.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    public final int id;
    public final String name;
    public List<SplitwiseUser> groupUserList;
    public List<Expense> expenseList;
    public final boolean simplify;
    public Map<SplitwiseUser, Double> simplifiedUserToExpenseMap = new HashMap<>();

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.simplify = false;
    }

    public void addUsersToGroup(List<SplitwiseUser> users){
        groupUserList = users;
    }

    public void addExpensesToGroup(List<Expense> expenses){
        expenseList = expenses;
    }

    @Override
    public String toString() {
        return "Group{" +
                "simplifiedUserToExpenseMap=" + simplifiedUserToExpenseMap +
                '}';
    }
}
