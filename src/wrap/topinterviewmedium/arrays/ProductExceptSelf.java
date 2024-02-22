package wrap.topinterviewmedium.arrays;

import java.util.Arrays;

/*
* https://leetcode.com/problems/product-of-array-except-self/description/
*
* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
*
* Input: nums = [1,2,3,4]
Output: [24,12,8,6]
*
*
* */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] nums1 = {2,3,-2,4};
        int[] ans = method1(nums1);
        int[] ans1 = method2(nums1);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ans1));
    }

    public static int[] method1(int[] nums){
        int size = nums.length;
        int[] prefix =new int[size];
        int[] suffix = new int[size];
        prefix[0] = 1; suffix[size-1] = 1;
        for(int i=1;i<size;i++){
            prefix[i] = nums[i-1]*prefix[i-1];
            suffix[size-i-1] = nums[size-i]*suffix[size-i];
        }
        for(int i=0;i<size;i++){
            suffix[i] = suffix[i]*prefix[i];
        }
        return suffix;
    }

    public static int[] method2(int[] nums){
        int size = nums.length;
        int[] output = new int[size];
        int prefix = 1;
        for(int i=0;i<size;i++){
            output[i] = prefix;
            prefix = prefix * nums[i];
        }
        int suffix = 1;
        for(int j=size-1;j>=0;j--){
            output[j] = output[j] * suffix;
            suffix = suffix * nums[j];
        }
        return output;
    }
}
