package prob151.reverse.words.in.a.string;

/**
 * Created by yanya04 on 9/10/2017.
 */
public class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();

        int len = format(cs);

        reverse(cs, 0, len - 1);

        int start = 0;
        for(int i = 0; i < len; i ++){
            if(cs[i] == ' '){
                reverse(cs, start, i - 1);
                start = i + 1;
            }
        }
        reverse(cs, start, len - 1);



        return new String(cs, 0, len);
    }

    private int format(char[] cs){
        int len = 0;
        for(int i = 0; i < cs.length; i ++){
            if(cs[i] != ' '){
                cs[len] = cs[i];
                len ++;
            } else {
                // spaces
                if(len == 0) continue;

                if(cs[len - 1] == ' ') continue;
                cs[len] = ' ';
                len ++;
            }
        }

        // remove tailing spaces

        if(len > 0 && cs[len - 1] == ' '){
            len = len - 1;
        }

        return len;
    }


    private void reverse(char[] cs, int start, int end){
        while(start < end){
            char temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            start ++; end --;
        }
    }
}