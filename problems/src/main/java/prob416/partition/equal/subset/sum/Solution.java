package prob416.partition.equal.subset.sum;

/*
    Created by yanya04 on 5/24/2018.
    Modified by yanay04 on 5/27/2018.
 */
public class Solution {
    /*
        knapsack 0-1
    */
    public boolean canPartition(int[] nums) {

        if(nums == null || nums.length == 0) return true;

        int sum = 0;
        for(int num: nums) sum += num;

        if((sum & 1) == 1) return false;
        sum = sum >> 1;

        // find if we can select numbers to fill in sum (half sum)

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= sum; j ++){
                dp[i][j] = dp[i - 1][j]; // if we dont pick nums[i], simply inherit the status from previous step
                if(j >= nums[i - 1]){
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];  // if we pick nums[i];
                }
            }
        }

        return dp[n][sum];
    }
}