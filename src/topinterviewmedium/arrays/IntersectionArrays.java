package topinterviewmedium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;

        List<Integer> list = new ArrayList<>();

        int i=0;int j=0;int k=0;
        while(i<len1 && j<len2){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                k++;i++;j++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                i++;
            }

        }
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        return nums;
    }

    public static void print(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}; int[] nums2 = {9,4,9,8,};
        int[] nums = intersect(nums1, nums2);
        print(nums);
    }
}
