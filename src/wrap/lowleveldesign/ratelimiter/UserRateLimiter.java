package wrap.lowleveldesign.ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class UserRateLimiter {

    Map<Integer, RateLimiter> userRateLimitMap;

    public UserRateLimiter(int id, RateLimiter rateLimiter) {
        this.userRateLimitMap = new HashMap<>();
        userRateLimitMap.put(id, rateLimiter);
    }

    synchronized void accessApplication(int id){
        if(userRateLimitMap.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName()+" has access");
        }
        else{
            System.out.println(Thread.currentThread().getName()+" donot have access");
        }
    }
}
