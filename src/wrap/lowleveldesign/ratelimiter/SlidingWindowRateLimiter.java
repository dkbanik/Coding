package wrap.lowleveldesign.ratelimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowRateLimiter implements RateLimiter{

    Queue<Long> slidingWindow;
    int timeFrameInSecs;
    int windowCapacity;

    public SlidingWindowRateLimiter(int timeFrameInSecs, int windowCapacity) {
        this.slidingWindow = new ConcurrentLinkedQueue<Long>();;
        this.timeFrameInSecs = timeFrameInSecs;
        this.windowCapacity = windowCapacity;
    }


    @Override
    public boolean grantAccess() {
        Long currentTime = System.currentTimeMillis();

        checkAndUpdate(currentTime);
        if(slidingWindow.size() < windowCapacity){
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }

    private void checkAndUpdate(Long currentTime) {

        if (slidingWindow.isEmpty())return;
        long timeDifference = (currentTime - slidingWindow.peek())/1000;

        while (!slidingWindow.isEmpty() && timeDifference > timeFrameInSecs){
            slidingWindow.poll();
        }
        return;
    }
}
