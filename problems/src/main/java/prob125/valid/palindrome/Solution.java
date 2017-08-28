package prob125.valid.palindrome;

/**
 * Created by yanya04 on 8/27/2017.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return true;

        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();

        char[] arr = s.toCharArray();
        while(i < j){

            while(i < j && !Character.isLetterOrDigit(arr[i])) i ++;

            while(i < j && !Character.isLetterOrDigit(arr[j])) j --;

            if(arr[i] != arr[j]) return false;

            i++;
            j--;
        }
        return true;
    }

}
