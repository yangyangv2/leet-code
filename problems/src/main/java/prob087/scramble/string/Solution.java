package prob087.scramble.string;

/**
 * Created by yanya04 on 1/6/2018.
 */
public class Solution {
    /*
        solution: divide and conquer or bruteforce
    */
    public boolean isScramble(String s1, String s2) {

        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        int n = s1.length();


        int[] letters = new int[26];
        for(int i = 0; i < n; i ++){
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i ++){
            if(letters[i] != 0) return false;
        }


        for(int i = 1; i < n; i ++){

            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;


            if(isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i)))
                return true;

        }

        return false;


    }
}
