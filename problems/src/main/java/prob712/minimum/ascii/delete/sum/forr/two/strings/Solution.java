package prob712.minimum.ascii.delete.sum.forr.two.strings;

/**
 * Created by yanya04 on 1/3/2018.
 */
public class Solution {
    public int minimumDeleteSum(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i ++)
            dp[i][0] = (int) s1.charAt(i - 1) + dp[i - 1][0];

        for(int i = 1; i <= len2; i ++)
            dp[0][i] = (int) s2.charAt(i - 1) + dp[0][i - 1];

        for(int i = 1; i <= len1; i ++)
            for(int j = 1; j <= len2; j ++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete1 = dp[i - 1][j] + (int)s1.charAt(i - 1);
                    int delete2 = dp[i][j - 1] + (int)s2.charAt(j - 1);
                    dp[i][j] = Math.min(delete1, delete2);
                }
            }

        return dp[len1][len2];

    }
}