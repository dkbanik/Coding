package wrap.dynamicprogramming;
//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class LargestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-99,-26,78,-50,-12,-10};
        int n = 6;
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
