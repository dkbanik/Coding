package lowleveldesign.splitwise.service;



import lowleveldesign.splitwise.model.Expense;
import lowleveldesign.splitwise.model.Group;
import lowleveldesign.splitwise.model.SplitwiseUser;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GroupService {

    BalanceSheetService balanceSheetService;

    public Map<Integer, Group> groupMap = new HashMap<>();

    public GroupService(BalanceSheetService balanceSheetService) {
        this.balanceSheetService = balanceSheetService;
    }

    public int createGroup(){
        Group group1 = new Group(1, "friends" );
        groupMap.put(group1.id, group1);
        return group1.id;
    }

    public void addUsersToGroup(int groupId, List<SplitwiseUser> users){
        Group group = groupMap.get(groupId);
        group.addUsersToGroup(users);
    }

    public void addExpensesToGroup(int groupId, List<Expense> expenseList){
        Group group = groupMap.get(groupId);
        group.addExpensesToGroup(expenseList);
    }

    public Map<SplitwiseUser, Double> getGroupBalance(int groupId){
        Map<SplitwiseUser, Double> userBalances = new HashMap<>();
        Group group = groupMap.get(groupId);
        List<Expense> expenses = group.expenseList;
        List<SplitwiseUser> users = group.groupUserList;
        for(Expense expense : expenses){
            expense.splitExpense(expense, users);
            Map<SplitwiseUser, Double> expenseUserMap = expense.expenseToUserBalanceMap.get(expense.id);
            balanceSheetService.updateUserBalanceSheet(expense);
            for(Map.Entry<SplitwiseUser, Double> entry : expenseUserMap.entrySet()){
                userBalances.put(entry.getKey(), userBalances.getOrDefault(entry.getKey(),0.0)+entry.getValue());
            }

        }
        return userBalances;
    }

    public Map<SplitwiseUser, Map<SplitwiseUser, Double>> simplifyExpense(int groupId){
        Map<SplitwiseUser, Map<SplitwiseUser, Double>> simplifiedBalanceGraph = new HashMap<>();
        Map<SplitwiseUser, Double> simplifiedUserBalance = getGroupBalance(groupId);

        Comparator<Map.Entry<SplitwiseUser, Double>> ascending = Comparator.comparingDouble(amount -> amount.getValue());
        Queue<Map.Entry<SplitwiseUser, Double>> positiveQueue = new PriorityQueue<>(ascending.reversed());
        Queue<Map.Entry<SplitwiseUser, Double>> negativeQueue = new PriorityQueue<>(ascending);

        for(Map.Entry<SplitwiseUser, Double> entry: simplifiedUserBalance.entrySet()){
            if(entry.getValue() > 0){
                positiveQueue.add(entry);
            }
            else {
                negativeQueue.add(entry);
            }
        }

        while (!positiveQueue.isEmpty()){
            Map.Entry<SplitwiseUser, Double> positiveEntry = positiveQueue.poll();
            Map.Entry<SplitwiseUser, Double> negativeEntry = negativeQueue.poll();

            Double postiveValue = positiveEntry.getValue();
            Double negativeValue = -negativeEntry.getValue();

            simplifiedBalanceGraph.putIfAbsent(positiveEntry.getKey(), new HashMap<>());
            simplifiedBalanceGraph.get(positiveEntry.getKey()).put(negativeEntry.getKey(), Math.min(postiveValue, negativeValue));

            Double remaining = postiveValue - negativeValue;
            if(remaining > 0){
                positiveQueue.add(new AbstractMap.SimpleEntry<>(positiveEntry.getKey(), remaining));
            } else if (remaining < 0) {
                negativeQueue.add(new AbstractMap.SimpleEntry<>(negativeEntry.getKey(), remaining));
            }

        }
        return simplifiedBalanceGraph;
    }

}
