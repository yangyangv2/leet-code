package prob322.coin.change;

import java.util.Arrays;

/**
 * Created by yanya04 on 3/8/2018.
 * Modified by yanya04 on 5/17/2018.
 * Modified by yanya04 on 5/27/2018.
 */
public class Solution {

    /*
        dp[i] = number of coins can make up to value i
        dp[i] = min(for each coins dp[i - coins[i]])
    */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 0; i <= amount; i ++){
            for(int j = 0; j < coins.length; j ++){
                if(i - coins[j] < 0) continue;
                if(dp[i - coins[j]] != -1){
                    dp[i] = Math.min(dp[i - coins[j]] + 1,
                            dp[i] == -1 ? Integer.MAX_VALUE: dp[i] );
                }
            }
        }
        return dp[amount];
    }
}