package prob416.partition.equal.subset.sum;

/*
    Created by yanya04 on 5/24/2018.
    Modified by yanya04 on 5/27/2018.
    Modified by yanya04 on 6/2/2018.
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
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < n; i ++){
            for(int j = sum; j >= nums[i]; j --){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[sum];
    }
}