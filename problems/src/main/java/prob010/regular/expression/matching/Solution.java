package prob010.regular.expression.matching;


/**
 *  Modified by yanya04 on 5/15/2018.
 *  Modified by yanya04 on 6/2/2018.
 */
public class Solution {
    /*

    let dp[i][j] = matches at p[i] and s[j]

    init    dp[0][0] = true
            dp[i][0] = s[i] == * :  dp[i - 2][0]
                                 :  false

        1. p[i] == s[j] :   dp[i][j] = dp[i - 1][j - 1]
        2. p[i] == '.'  :   dp[i][j] = dp[i - 1][j - 1]
        3. p[i] == '*'  :   (p[i - 1] != s[j]):                          dp[i][j] = dp[i - 2][j]
                            (p[i - 1] == s[j] || p[i - 1] == '.')        dp[i][j] = dp[i - 2][j] ||
                                                                         dp[i][j] = dp[i - 1][j] ||
                                                                         dp[i][j] = dp[i][j - 1]

                            a): erase previous character, e.g. "a*" = ""        dp[i][j] = dp[i - 2][j]
                            b): denote one character, e.g. "a*" = "a"           ap[i][j] = dp[i - 1][j]
                            c): denote multiple characgter, e.g. "a*" = "aa"    dp[i][j] = dp[i][j - 1]
    */

    public boolean isMatch(String s, String p) {

        if(s == null && p == null) return true;
        if(s == null || p == null) return false;

        int m = p.length(), n = s.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 2; i <= m; i ++) {   // pattern
            if(p.charAt(i - 1) == '*'){
                dp[i][0] = dp[i - 2][0];
            }
        }

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                if(p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(i - 1) == '*'){

                    if(p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.'){
                        dp[i][j] = dp[i - 2][j] || dp[i - 1][j] || dp[i][j - 1];
                    } else if(p.charAt(i - 2) != s.charAt(j - 1)){
                        dp[i][j] = dp[i - 2][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}