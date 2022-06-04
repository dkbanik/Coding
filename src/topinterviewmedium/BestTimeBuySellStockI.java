package topinterviewmedium;

public class BestTimeBuySellStockI {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        int minPrice=Integer.MAX_VALUE;;
        for(int i=0;i<len;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
