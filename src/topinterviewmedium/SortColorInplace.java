package topinterviewmedium;

public class SortColorInplace {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        for (int val : nums){
            System.out.print(val + " ");
        }
    }

    public static void sortColors(int[] nums) {
        int size = nums.length;
        int i = 0; int k = size-1;
        int j=i;
        while(j<=k){
            if(nums[j] == 0){
                swap(nums,i,j);
                i++;j++;
            }
            else if(nums[j] == 1){
                j++;
            }
            else if(nums[j] == 2){
                swap(nums,j,k);
                k--;
            }
        }
        return;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
