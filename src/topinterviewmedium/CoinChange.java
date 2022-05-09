package topinterviewmedium;

import java.util.Arrays;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2,5};
        int amount = 6;
        //System.out.println(Math.abs(1+Integer.MAX_VALUE));
        System.out.print(coinChangeV2(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount ==0 )return 0;
        int[] amountDp = new int[amount+1];
        Arrays.fill(amountDp,amount+1);
        amountDp[0] = 0;
        amountDp[amount] = amount+1;
        for(int i=1;i<=amount;i++){
            for(int coin: coins){
                if(i >= coin){
                    amountDp[i] = Math.min(amountDp[i],1+amountDp[i-coin]);
                }
            }
        }
        return amountDp[amount] == amount+1 ? -1: amountDp[amount];
    }

    public static int coinChangeV2(int[] coins, int target){
        if(target ==0 )return 0;
        int endIndex = coins.length - 1;
        int[][] cache = new int[coins.length][target+1];
        for(int i = 0;i<cache.length;i++){
            Arrays.fill(cache[i], -1);
        }
        return subProblem(endIndex, target, cache, coins);
    }

    public static int subProblem(int index, int target, int[][] cache, int[] coins){
        if(cache[index][target] != -1) return cache[index][target];
        int optimal;

        int chance_take;
        int chance_leave;

        int denomination = coins[index];

        // i can take chance and use the denomination
        if(denomination == target){
            chance_take = 1;
        }
        // i cant take the chance, so set to max value
        else if(denomination > target){
            chance_take = Integer.MAX_VALUE - 1;
        }
        // i can take the chance, but then we need to solve the new subproblem
        else {
            chance_take = 1 + subProblem(index, target-denomination, cache, coins);
        }

        // we finished all denominations
        if(index == 0){
            // since no denomination left
            chance_leave = Integer.MAX_VALUE - 1;
        }
        else {
            // I dont want to use the denomination, so then need to solve the new subproblem
            chance_leave = subProblem(index-1, target, cache, coins);
        }
        optimal = Integer.min(chance_take, chance_leave);
        cache[index][target] = optimal;
        return optimal;
    }
}
