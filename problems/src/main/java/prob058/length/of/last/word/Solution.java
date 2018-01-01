package prob058.length.of.last.word;

/**
 * Created by yanya04 on 12/27/2017.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        s = trim(s);
        return s.substring(1 + s.lastIndexOf(" ")).length();
    }

    private String trim(String input){
        if(input == null) return null;
        int start = 0, end = input.length() - 1;
        while(start <= end && input.charAt(start) == ' ') start ++;
        while(start < end && input.charAt(end) == ' ') end --;
        return input.substring(start, end + 1);
    }
}