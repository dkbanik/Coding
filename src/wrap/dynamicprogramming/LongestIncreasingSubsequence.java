package wrap.dynamicprogramming;

import java.util.Arrays;

//https://www.youtube.com/watch?v=qEh5uA8sx8w&list=PLDdcY4olLQk3Z2Gyo3-VN8gvi7DRKK-YY&index=23
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int length = arr.length;
        lis(arr);
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
