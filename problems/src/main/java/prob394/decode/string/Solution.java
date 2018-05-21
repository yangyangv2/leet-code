package prob394.decode.string;

import java.util.Stack;

/**
 *  Modified by yanya04 on 5/20/2018.
 *  Modified by yanya04 on 5/21/2018.
 */
public class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> words = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        char c = 0;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String str = null;
        words.push(new StringBuilder());
        for(int i = 0; i < s.length(); i ++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                sb.setLength(0);
                sb.append(c);
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    sb.append(s.charAt(++i));
                }
                count = Integer.parseInt(sb.toString());
                counts.push(count);
            } else if(c == '['){
                words.push(new StringBuilder());
            } else if(c == ']'){
                count = counts.pop();
                str = words.pop().toString();
                for(int j = 0; j < count; j ++)
                    words.peek().append(str);
            } else {
                words.peek().append(c);
            }
        }
        return words.pop().toString();
    }
}