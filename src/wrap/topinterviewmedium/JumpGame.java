package wrap.topinterviewmedium;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums){
        int size = nums.length;
        int maxReachIndex = 0;
        int i=0;
        while(i<=maxReachIndex && i<size){
            if(maxReachIndex >= size-1)return true;
            maxReachIndex = Math.max(maxReachIndex, i+nums[i]);
            i++;
        }
        return false;
    }
}
