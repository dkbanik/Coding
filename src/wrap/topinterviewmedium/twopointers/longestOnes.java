package wrap.topinterviewmedium.twopointers;
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class longestOnes {
    public static void main(String[] args) {
        int[] nums = {1,0,0,1,1,0,1,0,1,1,1};
        int k=2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int j=-1;
        int count=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                count++;
            }
            while (count > k){
                j++;
                if(nums[j] == 0){
                    count--;
                }
            }
            max = Math.max(max, i-j);
        }
        return max;
    }
}
