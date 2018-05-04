package prob072.edit.distance;

/**
 * Created by yanya04 on 1/3/2018.
 * Modified by yanya04 on 4/28/2018
 */
public class Solution {
    /*
        change s to t
        dp[i][j]: min steps to change s[i] to t[i]

        dp[0][j] = j (insert)
        dp[i][0] = i (delete)

        s: ... a
        t: ... a


        dp[i][j] = s[i] == s[j] ?
            min{dp[i - 1][j - 1], dp[i - 1][j] + 1, dp[i][j - 1] + 1}:
                    (adopt)         (insert)            (delete)
            min{dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1}
                    (replace)       (insert)            (delete)


    */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i ++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; j ++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                // insert, delete
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                // adopt or replace
                dp[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1))?
                        Math.min(dp[i][j], dp[i - 1][j - 1]) :
                        Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }

        return dp[m][n];
    }
}
