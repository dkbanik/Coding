package topinterviewmedium.arrays;

public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] > nums[i]){
                swap(i+1, j, nums);
                i++;
            }
        }
        return i+1;
    }

    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
