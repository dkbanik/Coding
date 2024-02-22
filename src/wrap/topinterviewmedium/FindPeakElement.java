package wrap.topinterviewmedium;
//https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {
    static int index = 0;
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakNumber(nums));
    }

    public static int findPeakNumber(int[] nums){
        int l=0;int r=nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>nums[mid+1]){
                r = mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public static int findPeakElement(int[] nums) {
        int i = 0;int j = nums.length-1;
        findPeak(nums,i,j);
        return index;
    }

    public static void findPeak(int[] nums, int i, int j){
        if(i == j) {
            index = i;return;
        }
        int mid = (i+j)/2;

        if(mid == i){
            index = nums[mid]>nums[j]? mid : j;
            return;
        }
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
            index=mid;
            return;
        }
        else if (nums[mid+1]>nums[mid]){
            findPeak(nums,mid+1,j);
        }
        else if(nums[mid-1]>nums[mid]){
            findPeak(nums,i,mid-1);
        }
        return;
    }
}
