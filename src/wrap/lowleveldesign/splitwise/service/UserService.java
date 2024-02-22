package wrap.lowleveldesign.splitwise.service;


import wrap.lowleveldesign.splitwise.model.SplitwiseUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    public Map<Integer, SplitwiseUser> userMap = new HashMap<>();
    public List<SplitwiseUser> createUsers(){
        List<SplitwiseUser> users = new ArrayList<>();
        SplitwiseUser user1 = new SplitwiseUser(1,"ram");
        SplitwiseUser user2 = new SplitwiseUser(2, "sham");
        SplitwiseUser user3 = new SplitwiseUser(3, "jadhu");
        SplitwiseUser user4 = new SplitwiseUser(4, "madhu");
        userMap.put(user1.id, user1);userMap.put(user2.id, user2);userMap.put(user3.id, user3);userMap.put(user3.id, user3);userMap.put(user4.id, user4);
        users.add(user1);users.add(user2);users.add(user3);//users.add(user4);
        return users;
    }

    public SplitwiseUser getUser(int id){
        return userMap.get(id);
    }

    public void displayBalanceSheet(int userId){
        SplitwiseUser user = userMap.get(userId);
        System.out.println(user.balanceSheet);
    }
}
