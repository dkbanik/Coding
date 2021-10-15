package leetcode.others;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class KokoEatBananas {
    public static void main(String[] args) {
        int[] arr = {3,6,7,11}; // 30,11,23,4,20; h= 6
        int h=8;
        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        int size = arr.length;
        if(size==h){
            System.out.println(max);
        }else{
            int nearest;
            for(int val : sorted){
                if(val*h > sum){
                    nearest = val;
                }
            }


        }
    }
}
