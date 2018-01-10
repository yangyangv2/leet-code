package prob115.distinct.subsequences;

/**
 * Created by yanya04 on 1/9/2018.
 */
public class Solution {
    /*

                   T
               r a b b i t
             0 1 2 3 4 5 6

          0  1 0 0 0 0 0 0
        r 1  1 1 0 0 0
        a 2  1 1 1 0 0
        b 3  1 1 1 1 0
     S  b 4  1 1 1 2 1
        b 5  1
        i 6  1
        t 7  1

        dp[i][j]: number of subsequences of S[i], T[j]


        if(s[i] != t[j])
          dp[i][j] = dp[i - 1][j]
        else
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]



    */
    public int numDistinct(String s, String t) {

        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i ++)
            dp[i][0] = 1;

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){

                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
