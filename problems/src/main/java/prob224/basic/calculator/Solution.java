package prob224.basic.calculator;

import java.util.Stack;

/**
 * Created by yanya04 on 1/19/2018.
 * Modified by yanya04 on 5/16/2018.
 */
public class Solution {
    public int calculate(String s) {
        if(s == null) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        char c = 0;
        int val = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            c = s.charAt(i);
            switch(c) {
                case '(':   stack.push(val);
                    stack.push(sign);
                    val = 0;
                    sign = 1;
                    break;
                case ')':   val = stack.pop() * val + stack.pop();
                    break;
                case ' ':   break;
                case '+':   sign = 1;  break;
                case '-':   sign = -1; break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))){
                        sb.append(s.charAt(++i));
                    }
                    val += sign * Integer.parseInt(sb.toString());
            }
        }
        return val;

    }
}