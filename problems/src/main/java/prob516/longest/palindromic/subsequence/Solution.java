package prob516.longest.palindromic.subsequence;

/**
 * Created by yanya04 on 3/18/2018.
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {

        return solution2(s);
    }


    /*  dp
         i  0 1 2 3 4
      j  1  b b b a b
      0  b  1 0
      1  b  2 1
      2  b  3 2 1
      3  a  3 2 1 1
      4  b  4       1


         i 0 1 2 3 4
      j    c b b d
      0  c 1
      1  b 1 1
      2  b 1 2 1
      3  d 2     1

        dp[i][j]: the longest palindromic str between i and j
        dp[i][j] = if(char[i] == char[j]) then 2 + dp[i + 1][j - 1]
                   else: max(dp[i + 1][j], dp[i][j - 1])
    */
    private int solution2(String s){

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i ++) dp[i][i] = 1;

        for(int j = 1; j < n; j ++){            // j: 1, 2, 3
            for(int i = 0; i < j; i ++){        // i: 0  01, 012
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
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