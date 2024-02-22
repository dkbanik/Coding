package wrap.topinterviewmedium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Number{
    int val;
    int index;

    public Number(int val, int index) {
        this.val = val;
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return val == number.val && index == number.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, index);
    }
}
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] ans = twoSum(nums, target);
        System.out.println(ans[0]+" "+ ans[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        int size = nums.length;
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<size;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}
