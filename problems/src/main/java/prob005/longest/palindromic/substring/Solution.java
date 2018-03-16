package prob005.longest.palindromic.substring;

/**
 *
 */
public class Solution {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        // return bruteforce(s);
        // return dp(s);
        return cs(s);
    }

    /*
        center spread
    */

    private String maxStr = "";
    private int maxLen = 0;

    private String cs(String s){

        for(int i = 0; i < s.length(); i ++){
            longestP(s, i, i);
            longestP(s, i, i + 1);
        }
        return maxStr;
    }

    private void longestP(String s, int l, int r){
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) != s.charAt(r)){
                break;
            }

            if(r - l + 1 > maxLen){
                // watch the costly substring !!
                maxStr = s.substring(l, r + 1);
                maxLen = r - l + 1;
            }

            l --; r ++;
        }
    }




    /*  dp solution:    Time: O(n ^ 2), Space: O(n ^ 2)

        dp[i][j] = is palindrome between string i and j

        init:   dp[i][i] = true

        dp[i][j] = dp[i + 1][j - 1] && (str.charAt(i) == str.charAt(j));



    */

    private String dp(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // init
        for(int i = 0; i < n; i ++)
            dp[i][i] = true;

        String max = "";
        int len = 0;
        for(int j = 0; j < n; j ++) {           // end
            for(int i = 0; i <= j; i ++){       // start
                if(j - i > 2)
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                else
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                if(dp[i][j]) {
                    if(j - i + 1 > len){
                        // be careful with substring, it's costly
                        max = s.substring(i, j + 1);
                        len = max.length();
                    }
                }
            }
        }
        return max;
    }



    /*  bruteforce solution */
    private String bruteforce(String s){

        String max = "";

        for(int start = 0; start < s.length(); start ++){
            for(int i = start; i < s.length(); i ++){
                for(int j = i + 1; j <= s.length(); j ++){
                    String substr = s.substring(i, j);
                    if(isPalindrome(substr)){
                        if(max.length() < substr.length()){
                            max = substr;
                        }
                    }
                }
            }
        }
        return max;
    }

    private boolean isPalindrome(String str){
        for(int i = 0; i < str.length() / 2; i ++){
            if(str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }
}