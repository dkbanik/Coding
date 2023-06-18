package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// https://leetcode.com/problems/maximum-erasure-value/
public class MaximumErasureValue {
    public static void main(String[] args) {

        int[] nums = {187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
        int[] nums1 = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums1)); // ans = 16911
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int[] prefixSum = new int[len];
        prefixSum[0] = nums[0];
        for(int i=1;i<len;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int start=0;
        int end = 0;
        int maxSum = 0;
        int runningSum = 0;
        while(end < len){
            if(!map.containsKey(nums[end])){
                map.put(nums[end],end);
                runningSum+=nums[end];
                maxSum=Math.max(runningSum,maxSum);
            }
            else{
                start = Math.max(start,map.get(nums[end])+1);
                map.put(nums[end],end);
                runningSum = prefixSum[end] - prefixSum[start-1];
                maxSum=Math.max(runningSum,maxSum);
            }
            end++;
        }
        return maxSum;
    }


    // 2 pointer solution
    public int maximumUniqueSubarrayV2(int[] nums) {
        int maxScore = 0, currScore = 0;
        Set<Integer> set = new HashSet<>();

        for (int l=0, r=0; r<nums.length; r++) {
            while (!set.add(nums[r])) {
                currScore -= nums[l];
                set.remove(nums[l++]);
            }
            currScore += nums[r];
            maxScore = Math.max(maxScore, currScore);
        }

        return maxScore;
    }
}
