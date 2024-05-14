package wrap.topinterviewmedium.arrays;

/*
* https://www.youtube.com/watch?v=nhEMDKMB44g
*
* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
*
* Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
*
* Input: nums = [3,4,5,1,2]
Output: 1
*
* */
public class FindMinInSortedRotated {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2}; // 3,4,1,2,3
        int[] nums1 = {5,4,3,2,1};
        System.out.println(minimum(nums1));
    }
    public static int minimum(int[] nums){
        int n = nums.length;
        int l = 0;int r=n-1;
        int min = Integer.MAX_VALUE;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[l] <= nums[mid]){
                min = Math.min(min, nums[l]);
                l = mid+1;
            }
            else{
                min = Math.min(min, nums[mid]);
                r = mid-1;
            }
        }
        return min;
    }
}
