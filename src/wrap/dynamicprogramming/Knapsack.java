package wrap.dynamicprogramming;

import java.util.Arrays;
//https://www.youtube.com/watch?v=CE5DwMecKWE&list=PLDdcY4olLQk3Z2Gyo3-VN8gvi7DRKK-YY&index=14
public class Knapsack {
    public static void main(String[] args) {
        int n = 3;
        int W = 50;
        int[] val = {60,100,120};
        int[] wt = {10,20,30};

        int[][] cache = new int[n][W+1];
        for (int i=0;i<n;i++){
            Arrays.fill(cache[i],-1);
        }

        System.out.println(knapsack(val,wt,W,n-1,cache));
    }

    public static int knapsack(int[] val, int[] wt, int targetWeight, int index, int[][] cache){


        if(targetWeight == 0 || index == -1) return 0;

        if(cache[index][targetWeight] != -1 )return cache[index][targetWeight];

        if(wt[index] > targetWeight){
            return knapsack(val, wt, targetWeight, index-1, cache);
        }

        int takeChoice = val[index] + knapsack(val,wt,targetWeight-wt[index], index-1, cache);
        int leaveChoice = knapsack(val,wt,targetWeight,index-1,cache);

        cache[index][targetWeight] = Math.max(takeChoice,leaveChoice);
        return cache[index][targetWeight];
    }

    public static void printCache(int[][] cache){
        int n =cache.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(cache[i][j]);
            }
            System.out.println();
        }
    }
}
