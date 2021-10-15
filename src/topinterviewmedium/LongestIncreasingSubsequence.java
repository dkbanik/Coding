package topinterviewmedium;

import java.util.Arrays;

//https://www.youtube.com/watch?v=1qD1FLhKrIE
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;

        for(int i = 0;i<size;i++){
            int index = upper_bound(dp,nums[i]);
            if(nums[i]>dp[index-1] && nums[i]<dp[index]){
                dp[index] = nums[i];
            }
        }

        int longest = 0;

        for(int i=size;i>=0;i--){
            if(dp[i] !=  Integer.MAX_VALUE){
                longest = i;break;
            }
        }
        return longest;
    }

    public static int upper_bound(int[] dp, int num){
        int low = 0; int high = dp.length;
        while(low < high){
            int mid = low + (high-low)/2;
            if(dp[mid] > num){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
