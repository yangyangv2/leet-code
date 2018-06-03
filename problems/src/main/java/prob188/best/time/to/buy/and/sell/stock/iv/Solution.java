package prob188.best.time.to.buy.and.sell.stock.iv;

/**
 *  Created by yanya04 on 5/27/2018.
 *  Modified by yanya04 on 6/2/2018.
 */
public class Solution {

    private int greedysolve(int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /*
        init
        T[0][i][1] = MIN_VALUE,  you cannot hold any stock at day-0

          today          yesterday + hold  yesterday + sell
        T[i + 1][j][0] = max(T[i][j][0], dp[i][j][1] + prices[i]);          hold or sell
        T[i + 1][j][1] = max(T[i][j][1], dp[i][j - 1][0] - prices[i]);      hold or buy
         today           yesterday + buy   yesterday + buy (spent a trans)
    */
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices == null || prices.length < 2) return 0;
        if(k >= prices.length / 2) return greedysolve(prices);

        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 1][2];
        for(int i = 0; i <= k; i ++){
            dp[0][i][1] = Integer.MIN_VALUE;
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