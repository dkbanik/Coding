package wrap.dynamicprogramming;
//https://leetcode.com/problems/house-robber-ii/description/
// houses are in circular & cant rob from neighbour
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        nums = new int[]{0};
        System.out.println(rob(nums));
        System.out.println(maxRob(nums));
    }

    public static int maxRob(int[] nums){
        int len = nums.length;
        if(len == 1) return nums[0];
        int robWithoutLast = maxRob(nums,0, len-2); // (0,2)
        int robWithoutFirst = maxRob(nums, 1, len-1); // (1,3)
        return Math.max(robWithoutFirst, robWithoutLast);
    }

    public static int maxRob(int[] nums, int start, int end){
        int len = nums.length;
        int[] maxRobbed = new int[len+1];
        maxRobbed[start] = 0; // extra to store -2th position
        maxRobbed[start+1] = nums[start];
        for(int i= start+1;i<=end;i++){
            maxRobbed[i+1] = Math.max(maxRobbed[i], maxRobbed[i-1]+nums[i]);
        }
        return maxRobbed[end+1];
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int first = 0;
        int second = nums[0];
        for(int i=1;i<n-1;i++){
            int temp = Math.max(second,first+nums[i]);
            first = second;
            second = temp;
        }
        int ans1 = second;
        first = 0;
        second = nums[1];
        for(int i=2;i<n;i++){
            int temp = Math.max(second,first+nums[i]);
            first = second;
            second = temp;
        }
        int ans2 = second;
        if(ans1 > ans2) return ans1;
        return ans2;
    }
}
