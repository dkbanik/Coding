package lowleveldesign.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {

        UserRateLimiter userRateLimiter = new UserRateLimiter(1);
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for(int i=1;i<=12;i++){
            executorService.execute(()->userRateLimiter.accessApplication(1));
        }
        executorService.shutdown();

    }
}
