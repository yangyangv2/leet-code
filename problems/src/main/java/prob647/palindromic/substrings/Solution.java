package prob647.palindromic.substrings;

/**
 * Created by yanya04 on 5/8/2018.
 */
public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];  // str[i, j] is a palindrome

        int count = 0;
        for(int i = 0; i < n; i ++){
            f[i][i] = true;
        }

        for(int end = 0; end < n; end ++){
            for(int start = 0; start <= end; start ++){

                if(end - start > 1)
                    f[start][end] = f[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
                else
                    f[start][end] = s.charAt(start) == s.charAt(end);

                if(f[start][end]) count ++;
            }
        }
        return count;
    }
}