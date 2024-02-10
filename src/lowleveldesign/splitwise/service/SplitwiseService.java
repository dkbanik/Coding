package lowleveldesign.splitwise.service;



import lowleveldesign.splitwise.model.Expense;
import lowleveldesign.splitwise.model.SplitwiseUser;

import java.util.List;
import java.util.Map;

public class SplitwiseService {
    GroupService groupService ;
    ExpenseService expenseService ;
    public UserService userService;
    public BalanceSheetService balanceSheetService;

    public void createServices(){
        userService = new UserService();
        balanceSheetService = new BalanceSheetService();
        expenseService = new ExpenseService(userService);
        groupService = new GroupService(balanceSheetService);
    }

    public void showGroupBalance(){
        List<SplitwiseUser> userList = userService.createUsers();
        int groupId = groupService.createGroup();
        List<Expense> expenseList = expenseService.createExpenses();
        groupService.addUsersToGroup(groupId, userList);
        groupService.addExpensesToGroup(groupId, expenseList);
        Map<SplitwiseUser, Double> userBalance = groupService.getGroupBalance(groupId);
        System.out.println(userBalance);
    }

    public void showSimplifyExpense(){
        Map<SplitwiseUser, Map<SplitwiseUser, Double>> map = groupService.simplifyExpense(1);
        System.out.println(map);
    }
}
