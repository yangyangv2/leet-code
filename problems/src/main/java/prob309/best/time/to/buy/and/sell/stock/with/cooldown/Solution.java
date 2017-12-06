package prob309.best.time.to.buy.and.sell.stock.with.cooldown;

import static java.lang.Math.*;

public class Solution {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length < 2)
            return 0;


        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = -prices[0];
        buy[1] = max(-prices[0], -prices[1]);
        sell[0] = 0;
        sell[1] = max(buy[0] + prices[1], sell[0]);


        for(int i = 2; i < n; i ++){
            buy[i] = max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = max(buy[i - 1] + prices[i], sell[i - 1]);
        }

        return sell[n - 1];

    }
}