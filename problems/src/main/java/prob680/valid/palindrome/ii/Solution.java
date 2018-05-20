package prob680.valid.palindrome.ii;

/**
 *  Created by yanya04 on 5/20/2018.
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalinedrome(s, left + 1, right) || isPalinedrome(s, left, right - 1);
            } else {
                left ++; right --;
            }
        }
        return true;

    }
    public boolean isPalinedrome(String s, int lo, int hi){
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi))
                return false;
            else {
                lo ++; hi --;
            }
        }
        return true;
    }
}