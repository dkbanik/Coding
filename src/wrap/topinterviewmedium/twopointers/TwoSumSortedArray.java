package wrap.topinterviewmedium.twopointers;


// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] arr = {-1,0}; // 9
        int[] ans = twoSum(arr, -1);

    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int low = 0;
        int high = numbers.length-1;
        while(low<high){
            int sum = numbers[low]+numbers[high];
            if(sum == target){
                ans[0] = low+1;
                ans[1] = high+1;
                return ans;
            }else if(sum > target){
                high--;
            }else{
                low++;
            }
        }
        return ans;
    }



}
