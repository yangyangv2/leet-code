package prob122.best.time.to.buy.and.sell.stock.ii;

/**
 * Created by yanya04 on 12/2/2017.
 * Modified by yanya04 on 4/29/2018.
 * Modified by yanya04 on 5/27/2018.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][] dp = new int[n + 1][2];

        dp[0][0] = 0; dp[0][1] = Integer.MIN_VALUE;

        for(int i = 0; i < n; i ++){
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }

        return dp[n][0];
    }
}