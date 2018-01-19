package prob214.shortest.palindrome;

/**
 * Created by yanya04 on 1/19/2018.
 */
public class Solution {

    /*
        case 1
                i
             aacecaa a
           a aacecaa a
                j  e

        case 2
                 i
                 a bcd
             dcb a bcd
                 j
                 e
    */
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = j;
        char[] chars = s.toCharArray();
        while(i < j){
            if(chars[i] == chars[j]){
                i ++; j --;
            } else {
                end --;
                j = end;
                i = 0;
            }
        }

        StringBuilder sb = new StringBuilder(s.substring(end + 1));
        return sb.reverse().toString() + s;


    }
}
