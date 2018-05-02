package prob122.best.time.to.buy.and.sell.stock.ii;

/**
 * Created by yanya04 on 12/2/2017.
 * Modified by yanya04 on 4/29/2018.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i ++){
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}