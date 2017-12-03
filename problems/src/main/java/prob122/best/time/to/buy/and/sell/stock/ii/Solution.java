package prob122.best.time.to.buy.and.sell.stock.ii;

/**
 * Created by yanya04 on 12/2/2017.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] > prices[i - 1]){
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}