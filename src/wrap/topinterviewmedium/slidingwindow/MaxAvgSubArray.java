package wrap.topinterviewmedium.slidingwindow;
//https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
/*
* You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
*
* */
public class MaxAvgSubArray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};int k=4;
        int len=0;int i=0;int j=0;
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        while(j < nums.length){
            while(len < k){
                sum+=nums[j];
                len++;j++;
            }
            maxSum = Math.max(maxSum, sum);
            sum-=nums[i];
            len--;
            i++;
        }
        double ans = (double) maxSum/k;
        System.out.println(ans);
    }
}
