package lowleveldesign.ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class UserRateLimiter {

    Map<Integer, SlidingWindowRateLimiter> userRateLimitMap;

    public UserRateLimiter(int id) {
        this.userRateLimitMap = new HashMap<>();
        userRateLimitMap.put(id, new SlidingWindowRateLimiter(1,10));
    }

    void accessApplication(int id){
        if(userRateLimitMap.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName()+" has access");
        }
        else{
            System.out.println(Thread.currentThread().getName()+" donot have access");
        }
    }
}
