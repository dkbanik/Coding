package wrap.topinterviewmedium.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.



Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
 */
public class MaxKSumPair {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3}; int k=6;
        System.out.println("Ans "+kSumUsingMap(nums,k));
        System.out.println("Ans is "+kSumUsingPointers(nums,k));
    }

    public static int kSumUsingMap(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int ops=0;
        for(int i=0;i<nums.length;i++){
            int diffNum = k - nums[i];
            if(map.containsKey(diffNum) && map.get(diffNum) != 0){
                ops++;
                map.put(diffNum, map.get(diffNum)-1);
            }else {
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
        }
        return ops;
    }

    public static int kSumUsingPointers(int[] nums, int k){
        Arrays.sort(nums);
        int i=0;int j=nums.length-1;
        int ops=0;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == k){
                ops++;
                i++;j--;
            }
            else if (sum < k) {
                i++;
            }else {
                j--;
            }
        }
        return ops;
    }
}
