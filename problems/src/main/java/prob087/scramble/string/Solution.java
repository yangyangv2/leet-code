package prob087.scramble.string;

/**
 * Created by yanya04 on 1/6/2018.
 * Modified by yanya04 on 5/8/2018.
 */
public class Solution {

    /*
        Memory Search, from prob[0, n], top-down

        if s1[n] is scramble of s2[n], as long as

        foreach k in(1..n)

        s1[0, k) is scramble of s2[0, k) && s1[k, n] is scramble of s2[k, n] ||
        s1[0, k) is scramble of s2[n - k, n) && s1[k, n) is scramble of s2[0, n - k)


    */
    public boolean isScramble(String s1, String s2) {

        int n = s1.length();
        boolean[][][] f = new boolean[n][n][n + 1];


        return isScramble(s1, 0, s2, 0, n, f);

    }

    private boolean validCheck(String s1, int start1, String s2, int start2, int len){
        int[] letters = new int[26];
        for(int i = 0; i < len; i ++){
            letters[s1.charAt(start1 + i) - 'a']++;
            letters[s2.charAt(start2 + i) - 'a']--;
        }

        for(int i = 0; i < 26; i ++){
            if(letters[i] != 0) return false;
        }
        return true;
    }

    private boolean isScramble(String s1, int start1, String s2, int start2, int len, boolean[][][] f){

        if(f[start1][start2][len]) return true;

        if(len == 1) {
            f[start1][start2][len] = s1.charAt(start1) == s2.charAt(start2);
            return f[start1][start2][len];
        }

        if(!validCheck(s1, start1, s2, start2, len)){
            return false;
        }

        for(int k = 1; k < len; k ++){
            f[start1][start2][len] =
                    isScramble(s1, start1, s2, start2, k, f) &&
                            isScramble(s1, start1 + k, s2, start2 + k, len - k, f) ||
                            isScramble(s1, start1, s2, start2 + len - k, k, f) &&
                                    isScramble(s1, start1 + k, s2, start2, len - k, f);

            if(f[start1][start2][len])
                return true;
        }

        return false;
    }

}
