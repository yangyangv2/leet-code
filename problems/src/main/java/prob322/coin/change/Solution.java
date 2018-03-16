package prob322.coin.change;

/**
 * Created by yanya04 on 3/8/2018.
 */
public class Solution {

    /*
        DP

        dp[j] = num of coins make up the value of [j]
        dp[0] = 0
        dp[n] = min(dp[n - coins[1]], dp[n - coins[2]], dp[n - coins[3]], ....)

    */
    public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i < amount + 1; i ++){
            int min = -1;
            for(int j = 0; j < coins.length; j ++){
                if(i < coins[j]) continue;
                if(dp[i - coins[j]] == -1) continue;
                if(min == -1){
                    min = dp[i - coins[j]] + 1;
                } else {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}