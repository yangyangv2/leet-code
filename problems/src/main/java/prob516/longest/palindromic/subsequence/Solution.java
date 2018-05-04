package prob516.longest.palindromic.subsequence;

/**
 * Created by yanya04 on 3/18/2018.
 * Modified by yanya04 on 3/20/2018.
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {

        return solution2(s);
    }

    /*
        dp solution

        dp[i][j] is the longest palindrome between i and j

        dp[i][j] = (char[i] == char[j])? 2 + dp[i + 1][j - 1]
                                        Math.max(dp[i + 1][j], dp[i][j - 1])

          j 0 1 2 3 4
        i   c b b d
        0 c 1 1
        1 b   1 1
        2 b     1
        3 d       1
        4

    */
    private int solution2(String s){
        if(s == null) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];


        for(int i = 0; i < n; i ++)
            dp[i][i] = 1;

        for(int i = n - 1; i >= 0; i --){
            for(int j = i + 1; j < n; j ++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }


    /*
        backtrack with memo
        top-down
    */
    private int solution1(String s){
        int n = s.length();

        return backtrack(s, 0, n - 1, new Integer[n][n]);
    }

    private int backtrack(String s, int i, int j, Integer[][] memo){

        if(memo[i][j] != null)
            return memo[i][j];

        if(i > j) return 0;
        if(i == j) return 1;

        if(s.charAt(i) == s.charAt(j)){
            memo[i][j] = backtrack(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(backtrack(s, i, j - 1, memo), backtrack(s, i + 1, j, memo));
        }

        return memo[i][j];
    }
}