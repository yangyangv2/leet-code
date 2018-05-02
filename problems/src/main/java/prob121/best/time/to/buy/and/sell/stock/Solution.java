package prob121.best.time.to.buy.and.sell.stock;

/**
 * Modified by yanya04 4/29/2018.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i ++){
            if(prices[i] < buy){
                buy = prices[i];
            }
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }
}