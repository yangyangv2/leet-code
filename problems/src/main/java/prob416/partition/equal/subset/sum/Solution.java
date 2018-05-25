package prob416.partition.equal.subset.sum;

/*
    Created by yanya04 on 5/24/2018.
 */
public class Solution {

/*
    dp[i][j] means whether the specific sum j can be gotten from the first i numbers.

*/
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num: nums){
            sum += num;
        }

        if((sum & 1) == 1) return false;

        sum = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 0; i < n + 1; i ++){
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];

    }
}