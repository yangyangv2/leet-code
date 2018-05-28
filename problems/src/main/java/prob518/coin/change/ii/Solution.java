package prob518.coin.change.ii;

/**
 *  Created by yanya04 on 5/27/2018.
 */
public class Solution {
    /*
        dp[i] number of ways up to i

        dp[i] = sums of {dp[i - coins[1]], dp[i - coins[2]] ...}
    */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = 0; i < coins.length; i ++){
            for(int j = 0; j <= amount; j ++){
                if(j - coins[i] < 0) continue;
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}