package wrap.lowleveldesign.ratelimiter;

public class TokenBucketRateLimiter implements RateLimiter{

    private int maxBucketSize;
    private int currBucketSize;
    private int refillRate;
    private long lastRefilledTimestamp;

    TokenBucketRateLimiter(int refillRate, int maxBucketSize){
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        this.currBucketSize = maxBucketSize;
        this.lastRefilledTimestamp = System.currentTimeMillis();
    }

    @Override
    public boolean grantAccess() {
        refill();
        if(currBucketSize>=1){
            currBucketSize-=1;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        int tokensToAdd = (int)(((lastRefilledTimestamp - now)*refillRate)/1000);
        currBucketSize = Math.min(currBucketSize+tokensToAdd, maxBucketSize );
        lastRefilledTimestamp = now;
    }
}
