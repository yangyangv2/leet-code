package prob125.valid.palindrome;

/**
 * Created by yanya04 on 8/27/2017.
 * Modified by yanya04 on 5/19/2018.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return true;

        s = s.toLowerCase();
        int lo = 0, hi = s.length() - 1;

        while(lo < hi){
            while(lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) lo ++;
            while(lo < hi && !Character.isLetterOrDigit(s.charAt(hi))) hi --;
            if(lo > hi) break;
            if(s.charAt(lo) != s.charAt(hi)) return false;
            lo ++; hi --;
        }
        return true;
    }
}