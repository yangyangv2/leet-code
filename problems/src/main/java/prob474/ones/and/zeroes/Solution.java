package prob474.ones.and.zeroes;

/**
 *  Created by yanya04 on 5/27/2018.
 *  Modified by yanya04 on 6/2/2018.
 */
public class Solution {
    /*
        dp[i][j][k] = maxium covers with current str i, j '0' and k '1' used

        dp[i][j][k] = max(1 + dp[i - 1][j - count0(str[i])][k - count1[str[i]]], dp[i - 1][j][k]);

    */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for(int i = 1; i <= len; i ++){
            int[] cnts = count(strs[i - 1]);
            int ones = cnts[1], zeros = cnts[0];
            for(int j = 0; j <= m; j ++){
                for(int k = 0; k <= n; k ++){
                    if(j >= zeros && k >= ones){
                        dp[i][j][k] = Math.max(1 + dp[i - 1][j - zeros][k - ones], dp[i - 1][j][k]);
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