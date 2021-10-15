package topinterviewmedium;

import java.util.Arrays;

public class IncreasingTripletSubseq {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }

    public static boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= i){
                i = num;
            }
            else if(num <= j){
                j = num;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
