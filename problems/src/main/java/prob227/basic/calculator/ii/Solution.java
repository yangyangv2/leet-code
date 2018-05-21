package prob227.basic.calculator.ii;

import java.util.Stack;

/**
 * Created by yanya04 on 1/19/2018.
 * Modified by yanya04 on 5/16/2018.
 * Modified by yanya04 on 5/19/2018.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    /*
        Input: " 3 - 5 / 2 "
        Output: 5
    */
    public int calculate(String s) {
        long sum = 0, mul = 1, sign1 = 1, sign2 = 1;
        char c = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                sb.setLength(0);
                sb.append(c);
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    sb.append(s.charAt(++ i));
                }
                long num = Long.parseLong(sb.toString());
                mul = sign2 == 1 ? mul * num : mul / num;
            } else if(c == '/'){
                sign2 = -1;
            } else if(c == '*'){
                sign2 = 1;
            } else if(c == '+' || c == '-') {
                sum += sign1 * mul;
                mul = 1;
                sign2 = 1;
                sign1 = (c == '+') ? 1 : -1;
            } else {
                // space ... ignore..
            }
        }
        return (int)(sum + sign1 * mul);
    }
}