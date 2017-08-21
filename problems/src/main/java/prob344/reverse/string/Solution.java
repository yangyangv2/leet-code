package prob344.reverse.string;

/**
 * Created by yanya04 on 8/20/2017.
 */
public class Solution
{
    public String reverseString(String s) {
        if(s == null) return null;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length / 2; i ++){
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        if(chars.length > 0){
            return new String(chars);
        } else {
            return "";
        }
    }
}
