package wrap.dynamicprogramming;
//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
// https://leetcode.com/problems/maximum-subarray/description/
public class LargestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int n = arr.length;
        System.out.println(maxSubarraySum(arr,n));
    }

    static long maxSubarraySum(int arr[], int n) {

        long sum = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] + arr[i] >= arr[i]) {
                arr[i] += arr[i - 1];
            }
            if (arr[i] > sum) {
                sum = arr[i];
            }
        }
        return sum;
    }
}
