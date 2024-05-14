package wrap.topinterviewmedium;

import java.util.Arrays;

//https://www.youtube.com/watch?v=1qD1FLhKrIE
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISV3(nums));
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

    //top down approach
    public static int lengthOfLISV2(int[] nums){
        int[] cache = new int[nums.length];
        int len = cache.length;
        Arrays.fill(cache,1);
        for(int j=nums.length-1;j>=0;j--){
            for(int i=j+1;i<len;i++){
                if(nums[j]<nums[i]){
                    cache[j] = Math.max(cache[j],1+cache[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<cache.length;i++){
            max = Integer.max(max, cache[i]);
        }
        return max;
    }

    //bottom up approach
    public static int lengthOfLISV3(int[] nums){
        int len = nums.length;
        int[] maxLenNums = new int[len];
        Arrays.fill(maxLenNums, 1);
        int finalMax = Integer.MIN_VALUE;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    maxLenNums[i] = Math.max(1+maxLenNums[j], maxLenNums[i]);
                }
            }
            finalMax = Math.max(finalMax, maxLenNums[i]);
        }
        return finalMax;
    }
}
