package wrap.topinterviewmedium.arrays;
// https://leetcode.com/problems/single-number/description/
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
