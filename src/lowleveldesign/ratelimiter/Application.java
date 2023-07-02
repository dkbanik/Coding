package lowleveldesign.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        RateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(1,10);
        RateLimiter tokenBucketRateLimiter = new TokenBucketRateLimiter(1, 10);

        UserRateLimiter userRateLimiter1 = new UserRateLimiter(1, slidingWindowRateLimiter);
        UserRateLimiter userRateLimiter2 = new UserRateLimiter(2, tokenBucketRateLimiter);
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for(int i=1;i<=12;i++){
            executorService.execute(()->userRateLimiter2.accessApplication(2));
        }
        executorService.shutdown();

    }
}
