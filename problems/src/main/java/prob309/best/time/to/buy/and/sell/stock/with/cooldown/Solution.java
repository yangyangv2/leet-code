package prob309.best.time.to.buy.and.sell.stock.with.cooldown;

import static java.lang.Math.*;

/**
 *  Created by yanya04 on 5/27/2018.
 *  Modified by yanya04 on 6/2/2018.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][] dp = new int[n + 1][2];

        dp[0][1] = Integer.MIN_VALUE;

        /*
            today        yesterday + rest   yesterday + sell
            T[i + 1][0] = max(T[i][0], T[i][1] + prices[i])
            T[i + 1][1] = max(T[i][1], T[i - 1][0] - prices[i])
            today        yesterday + hold   before yesterday + buy
        */
        for(int i = 0; i < n; i ++){
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], (i == 0? 0 : dp[i - 1][0]) - prices[i]);
        }
        return dp[n][0];

    }
}