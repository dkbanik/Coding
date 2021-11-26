package leetcode.others;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class KokoEatBananas {
    public static void main(String[] args) {
        int[] arr1 = {312884470}; // 30,11,23,4,20; h= 6 (4,30)=>17 ,  (17,30)=>23, (17,23)=>20, (20,23) =>  21, (21,23) => 22, (22,23)=>22
        int[] arr= {30,11,23,4,20};
        int h=5;

        System.out.println(minEatingSpeed(arr,h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = findMinElseMax(piles,false);
        return findEatSpeed(piles,1, max, h);
    }

    private static int findEatSpeed(int[] arr, int l, int r, int hour) {
        while(l<r){
            int mid = (l+r)/2;
            int hourToFinish = findHoursNeed(arr, mid);
            if (hourToFinish > hour){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }

    private static int findHoursNeed(int[] arr,int rate) {
        int count = 0;
        for(int num: arr){
            count+=Math.round(num/rate);
            if(num%rate != 0) count++;
        }
        return count;
    }

    public static int findMinElseMax(int[] arr, boolean flag){
        int num = arr[0];
        for(int i: arr){
            if(flag){
                num=Integer.min(num,i);
            }
            else {
                num = Integer.max(num,i);
            }
        }
        return num;
    }
}
