package topinterviewmedium.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if(k==0)return;
        int len = nums.length;
        k = k%len;
        reverse(0, len-k-1, nums);
        reverse(len-k, len-1, nums);
        reverse(0, len-1, nums);

    }

    public static void reverse(int i, int j, int[] nums){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void print(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3,4,5,6,7};
       int k = 3;
       rotate(nums, k);
        print(nums);
    }
}
