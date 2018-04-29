package prob409.longest.palindrome;

public class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for(int i = 0; i < s.length(); i ++){
            map[(int)s.charAt(i)] ++;
        }

        int res = 0;
        for(int i = 0; i < 128; i ++){
            if(map[i] / 2 > 0){
                res += map[i] / 2;
            }
        }
        res *= 2;

        if(res < s.length()) res ++;
        return res;
    }
}