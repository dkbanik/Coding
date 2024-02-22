package wrap.topinterviewmedium;

import java.util.Arrays;

public class ChocolateDistribution {
    //https://www.geeksforgeeks.org/chocolate-distribution-problem/
    public static void main(String[] args) {
        int[] arr = {12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50};

        int m = 7;
        int ans = findMinimumDifference(arr, m);
        System.out.println(ans);
    }

    public static int findMinimumDifference(int[] arr, int m){
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<=arr.length-m;i++){
            min = Math.min(min, arr[i+m-1]-arr[i]);
        }
        return min;
    }
}
