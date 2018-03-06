package prob312.burst.balloons;

/**
 * Created by yanya04 on 3/5/2018.
 */
public class Solution {
    /*
        DP: dp[i][j] = maximum coins between i and j
            dp[i][j] = max(dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1]);
    */
    public int maxCoins(int[] nums) {

        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][n];
        return dfs(nums, dp, 0, n - 1);
    }

    private int dfs(int[] nums, int[][] dp, int i, int j)
    {
        if(i < 0 || j == nums.length || j < i) return 0;

        if(dp[i][j] > 0) return dp[i][j];

        for(int k = i; k <= j; k ++){

            int left = i - 1 < 0 ? 1: nums[i - 1];
            int right = j + 1 == nums.length? 1: nums[j + 1];

            dp[i][j] = Math.max(dp[i][j],
                    nums[k] * left * right +
                            dfs(nums, dp, i, k - 1) +
                            dfs(nums, dp, k + 1, j));
        }
        return dp[i][j];
    }
}
