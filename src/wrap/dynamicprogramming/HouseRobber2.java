package wrap.dynamicprogramming;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int first = 0;
        int second = nums[0];
        for(int i=1;i<n-1;i++){
            int temp = Math.max(second,first+nums[i]);
            first = second;
            second = temp;
        }
        int ans1 = second;
        first = 0;
        second = nums[1];
        for(int i=2;i<n;i++){
            int temp = Math.max(second,first+nums[i]);
            first = second;
            second = temp;
        }
        int ans2 = second;
        if(ans1 > ans2) return ans1;
        return ans2;
    }
}
