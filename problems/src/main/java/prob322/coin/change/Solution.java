package prob322.coin.change;

import java.util.Arrays;

/**
 * Created by yanya04 on 3/8/2018.
 * Modified by yanya04 on 5/17/2018.
 * Modified by yanya04 on 5/27/2018.
 * Modified by yanay04 on 6/2/2018.
 */
public class Solution {

    /*
        dp[i] = number of coins can make up to value i
        dp[i] = min(for each coins dp[i - coins[i]])
    */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j ++){
                if(i - coins[j] < 0) continue;
                if(dp[i - coins[j]] == -1) continue;
                min = Math.min(dp[i - coins[j]] + 1, min);
            }
            dp[i] = (min == Integer.MAX_VALUE)? -1: min;
        }
        return dp[amount];
    }
}