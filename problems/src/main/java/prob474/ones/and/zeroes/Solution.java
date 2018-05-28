package prob474.ones.and.zeroes;

/**
 *  Created by yanya04 on 5/27/2018.
 */
public class Solution {
    /*
        dp[i][j][k] = maxium covers with current str i, j '0' and k '1' used

        dp[i][j][k] = max(1 + dp[i - 1][j - count0(str[i])][k - count1[str[i]]], dp[i - 1][j][k]);

    */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        int[][][] dp = new int[len + 1][m + 1][n + 1];
        dp[0][0][0] = 0;


        for(int i = 1; i <= len; i ++){
            int[] counts = count(strs[i - 1]);
            for(int j = 0; j <= m; j ++){
                for(int k = 0; k <= n; k ++){
                    int zeros = counts[0];
                    int ones = counts[1];
                    if(zeros <= j && ones <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k] ,
                                dp[i - 1][j - zeros][k - ones] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[len][m][n];
    }
    private int[] count(String str){
        int[] count = new int[2];
        for(int i = 0; i < str.length(); i ++){
            count[str.charAt(i) - '0']++;
        }
        return count;
    }
}