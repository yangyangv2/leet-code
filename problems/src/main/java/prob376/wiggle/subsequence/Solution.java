package prob376.wiggle.subsequence;

import java.util.Arrays;

/**
 * Created by yanya04 on 6/12/2018.
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int[][] dp = new int[n][2];

        // 0 for increase
        // 1 for decrease

        for(int i = 0; i < n; i ++){
            Arrays.fill(dp[i], 1);
        }

        int max = 1;
        for(int i = 1; i < n; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[j] < nums[i]){
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } else if(nums[j] > nums[i]){
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }

                max = Math.max(max, dp[i][1]);
                max = Math.max(max, dp[i][0]);
            }
        }

        return max;
    }
}
