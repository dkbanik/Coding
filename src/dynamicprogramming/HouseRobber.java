package dynamicprogramming;
// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2){
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int sec = Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            int temp = Math.max(sec, nums[i] + first);
            first = sec;
            sec = temp;

        }
        return sec;
    }
}
