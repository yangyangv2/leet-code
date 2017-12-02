package prob377.combination.sum.iv;

import java.util.Arrays;

public class Solution {

    /*  backpack problem
        f[n] = f[n - x] + x;
    */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;  // target == 0;
        return helper(nums, dp, target);
    }

    private int helper(int[] nums, int[] dp, int target) {

        if(dp[target] != -1) return dp[target];

        int res = 0;
        for(int i = 0; i < nums.length; i ++){
            if(target >= nums[i]){
                res += helper(nums, dp, target - nums[i]);
            }
        }

        dp[target] = res;

        return res;
    }

}