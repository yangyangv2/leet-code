package prob322.coin.change;

import java.util.Arrays;

/**
 * Created by yanya04 on 3/8/2018.
 * Modified by yanya04 on 5/17/2018.
 */
public class Solution {

    /*
        dp[j] = number of coins to make value j

        dp[j] = min{dp[j - coins[i]]} for i in (0...coins.length - 1)
    */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j ++){
                if(i - coins[j] < 0) continue;
                if(dp[i - coins[j]] == -1) continue;
                min = Math.min(min, dp[i - coins[j]]);
            }

            if(min < Integer.MAX_VALUE)
                dp[i] = min + 1;
        }

        return dp[amount];
    }
}