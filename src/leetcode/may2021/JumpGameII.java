package leetcode.may2021;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        //int[] nums = {2,3,1,1,4};
        int[] nums = {2,1};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<n-1;i++){
            int value = nums[i];
            for(int j=i+1;j<=i+value && j<n;j++){
                dp[j] = Math.min(dp[i]+1,dp[j]);
            }
        }
        return dp[n-1];
    }
}
