package prob123.best.time.to.buy.and.sell.stock.iii;

import static java.lang.Math.*;

/**
 *  Modified by yanya04 on 5/27/2018.
 */

public class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n + 1][k + 1][2];
        dp[0][0][0] = 0;

        for(int i = 0; i <= k; i ++){
            dp[0][i][1] = Integer.MIN_VALUE;
            // at 0th day, the possiblity of holding one stock is 0
        }

        for(int i = 0; i < n; i ++){
            for(int j = k; j > 0; j --){
                dp[i + 1][j][0] = Math.max(dp[i][j][0], dp[i][j][1] + prices[i]);
                dp[i + 1][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][0] - prices[i]);
            }
        }

        return dp[n][k][0];
    }
}