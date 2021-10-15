package topinterviewmedium;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        System.out.print(coinChange(coins,amount));
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
}
