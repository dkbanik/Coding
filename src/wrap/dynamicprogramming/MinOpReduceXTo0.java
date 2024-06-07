package wrap.dynamicprogramming;

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// https://www.youtube.com/watch?v=3p2fBvxrVQA
// https://www.youtube.com/watch?v=w7u9sMlx7zc
public class MinOpReduceXTo0 {
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        int x = 5;
        System.out.println(minOperations(nums,x));

    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        int target = sum-x;
        // now we need to find the max sub array which adds upto target

        if(target == 0) return nums.length;
        if(target < 0) return -1;
        int max = -1;
        int l = 0;
        int localSum = 0;
        for(int i=0;i<nums.length;i++){
            localSum+=nums[i];
            while(localSum > target){
                localSum-=nums[l];
                l++;
            }
            if(localSum == target){
                max = Math.max(max,i-l+1);
            }

        }
        return max == -1 ? -1 : (nums.length-max);
    }

    public static int minOps(int[][] cache, int i, int j, int target, int[] nums, int count){
        if(i>j || target < 0) return -1;

        if(target == 0) return count;

        if(cache[i][j] != 0) return cache[i][j];

        int leftMost = minOps(cache,i+1,j,target-nums[i],nums, count+1);
        int rightMost = minOps(cache, i, j-1, target-nums[j],nums, count+1);

        cache[i][j] = Math.min(leftMost, rightMost);
        return cache[i][j];
    }


}
