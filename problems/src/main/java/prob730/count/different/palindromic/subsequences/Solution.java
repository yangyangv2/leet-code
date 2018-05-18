package prob730.count.different.palindromic.subsequences;

/**
 *  Created by yanya04 on 5/15/2018.
 */
public class Solution {
    /*
        S = 'bccb'
        Output: 6

        'b', 'c', 'bb', 'cc', 'bcb', 'bccb'


        ""      =>  0
        "a"     =>  1
        "ab"    =>  2   "a", "b"
        "aa"    =>  2   "a", "aa"
        "abc"   =>  3   "a", "b", "c"
        "aba"   =>  4   "a", "aa", "aba", "b"                   a(b)a = 2 * 1 + 2
        "abba"  =>  6   "a", "aa", "aba", "abba", "bb", "b"     a(bb)a = 2 * 2 + 2 = 6
        "abbc"  =>  4   "a", "c" , "bb", "b"                    (abb) + (bbc) - (bb) = 2 + 2

        remove duplicate....


    */
    public int countPalindromicSubsequences(String S) {

        int n = S.length();
        long[][] dp = new long[n][n];

        for(int i = 0; i < n; i ++)
            dp[i][i] = 1;

        for(int j = 1; j < n; j ++){
            for(int i = j - 1; i >= 0; i --){
                if(S.charAt(i) == S.charAt(j)){

                    int left = i + 1, right = j - 1;
                    while(left <= right && S.charAt(left) != S.charAt(i)) left ++;
                    while(left <= right && S.charAt(right) != S.charAt(i)) right --;
                    if(left > right){
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else if(left == right){
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return (int) (dp[0][n - 1]);
    }
}