package prob097.interleaving.string;

/**
 * Created by yanya04 on 1/8/2018.
 */
public class Solution {

/*
    dp[] 2 d

    dp[i][j]: at i from s1 and j from s2 and i + j from s3, is it a interleaving string

    init:
    dp[0][0]: true

    function:

    dp[i][j]: dp[i - 1][j] && s1.charAt(i) == s3.charAt(i + j) || dp[i][j - 1] && s2.charAt(j) == s3.charAt(i + j);

*/

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if(m + n != l) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++){
            dp[i][0] = dp[i - 1][0] &&  s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for(int j = 1; j <= n; j ++){
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                        dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[m][n];
    }
}