package wrap.dynamicprogramming;

import java.util.Arrays;

//https://www.youtube.com/watch?v=qEh5uA8sx8w&list=PLDdcY4olLQk3Z2Gyo3-VN8gvi7DRKK-YY&index=23
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int length = arr.length;
        lis(arr);
        System.out.println(lis2(arr));
    }
    // memoization
    // time -> 0(n*2) space -> o(n*2)
    public static int lis2(int[] arr){
        int len = arr.length;
        int index = 0;
        int prevIndex = -1;
        int[][] dp = new int[len][len+1];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i], -1);
        }
        return lis2dp(index, prevIndex, arr, dp, len);
    }

    private static int lis2dp(int index, int prevIndex, int[] arr, int[][] dp, int n) {
        if(index == n) return 0;

        if(dp[index][prevIndex+1] != -1)return dp[index][prevIndex+1];
        int notTakelen = 0 + lis2dp(index+1, prevIndex, arr, dp, n);
        int takeLen = notTakelen;
        if(prevIndex == -1 || arr[index] > arr[prevIndex]){
            takeLen =  1 + lis2dp(index+1, index, arr, dp, n);
        }
        dp[index][prevIndex+1] = Math.max(takeLen, notTakelen);
        return dp[index][prevIndex+1];

    }

    public static void lis(int[] arr){
        int length = arr.length;
        int[] cache = new int[length];
        // be default all numbers will be of atleast 1 length
        Arrays.fill(cache,1);

        for (int i=1;i<length;i++){
            for (int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    cache[i] = Math.max(cache[i],1+cache[j]);
                }
            }
        }
        int ans = Arrays.stream(cache).max().getAsInt();
        System.out.println(ans);
        // time - o(n^2) space - 0(n)
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
