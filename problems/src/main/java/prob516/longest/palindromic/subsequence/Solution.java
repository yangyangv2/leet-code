package prob516.longest.palindromic.subsequence;

/**
 * Created by yanya04 on 3/18/2018.
 * Modified by yanya04 on 3/20/2018.
 * Modified by yanya04 on 5/15/2018.
 */
public class Solution {

    /*
        let dp[i][j] be the longest palinedrome between (i, j)

        dp[i][i] = 1;

        dp[i][j] =  (j - i <= 2)   A[i] == A[j] ? 2 : 0
                    (j - i > 2)    A[i] == A[j] dp[i + 1][j - 1] + 2


    */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i ++){
            dp[i][i] = 1;
        }

        for(int j = 1; j < n; j ++){
            for(int i = j - 1; i >= 0; i --){
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}