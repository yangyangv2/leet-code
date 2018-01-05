package prob072.edit.distance;

/**
 * Created by yanya04 on 1/3/2018.
 */
public class Solution {
    /*

        word1: abcde
        word2: ace

        dp[i][j]:  number of operations

        insert:    dp[i][j] = dp[i][j - 1] + 1
        delete:    dp[i][j] = dp[i - 1][j] + 1
        replace:   dp[i][j] = dp[i - 1][j - 1] + 1


              a b c d e
            0 1 2 3 4 5     insert
          0 0 1 2 3 4 5
        a 1 1
        c 2 2
        e 3 3

            delete          replace

    */
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0; i <= len1; i ++)
            dp[i][0] = i;
        for(int i = 0; i <= len2; i ++)
            dp[0][i] = i;

        for(int i = 1; i <= len1; i ++)
            for(int j = 1; j <= len2; j ++){

                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }


                int insert = dp[i][j - 1] + 1;
                int delete = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(Math.min(insert, delete), replace);
            }

        return dp[len1][len2];

    }
}
