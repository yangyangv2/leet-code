package prob005.longest.palindromic.substring;

public class Solution {
    public String longestPalindrome(String s) {

        if(s == null || s.length() < 2) return s;

        for(int i = 0; i < s.length(); i ++){
            checkPalindrome(i, i + 1, s);
            checkPalindrome(i, i, s);
        }

        return result;
    }

    private int maxLen = Integer.MIN_VALUE;
    private String result = "";

    private void checkPalindrome(int left, int right, String s){
        while(left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)){
            int len = right - left + 1;
            if(maxLen < len){
                maxLen = len;
                result = s.substring(left, right + 1);
            }
            right ++;
            left --;
        }
    }
}