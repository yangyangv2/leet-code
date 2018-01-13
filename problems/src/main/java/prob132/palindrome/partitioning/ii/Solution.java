package prob132.palindrome.partitioning.ii;

/**
 * Created by yanya04 on 1/12/2018.
 */
public class Solution {

    int minCut = Integer.MAX_VALUE;

    public int minCut(String s) {

        // return backtrack(s);
        return dp(s);
    }


    /*
        dp[i][j]: is substring(i, j + 1) is a palindrom

        dp[i][j] = charAt(i) == charAt(j) && (( j - i < 3 ) || dp[i + 1][j - 1]);

    */

    private int dp(String s){

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] cuts = new int[n];

        for(int i = 0; i < n; i ++){
            int min = i;
            for(int j = 0; j <= i; j ++){
                if(s.charAt(i) == s.charAt(j) && ( i - j < 2 || dp[i - 1][j + 1])){
                    // String(j~i) is a palindrom
                    //
                    dp[i][j] = true;
                    min = j == 0? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }
        return cuts[n - 1];
    }



    private int backtrack(String s){
        if(s == null || s.length() < 2)
            return 0;
        backtrack(s, -1);
        return minCut;
    }


    private void backtrack(String s, int depth){
        if(s.length() == 0){
            minCut = Math.min(minCut, depth);
            return;
        }

        for(int i = 0; i < s.length(); i ++){
            String t = s.substring(0, i + 1);
            if(isPalindrome(t)){
                backtrack(s.substring(i + 1), depth + 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        for(int i = 0; i < s.length() / 2; i ++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }
}
