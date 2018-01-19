package prob227.basic.calculator.ii;

import java.util.Stack;

/**
 * Created by yanya04 on 1/19/2018.
 */
public class Solution {

/*
    "3+2*2" = 7
    " 3/2 " = 1
    " 3+5 / 2 " = 5
*/

    public int calculate(String s) {

        return stack(s);

    }

    private int stack(String s){

        Stack<Integer> stack = new Stack<>();

        char sign = '+';

        int cur = 0;

        for(int i = 0; i < s.length(); i ++){

            if(Character.isDigit(s.charAt(i))){
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i));
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)))
                    sb.append(s.charAt(1 + i++));

                cur = Integer.parseInt(sb.toString());
            }
            char c = s.charAt(i);
            // evaluate
            if( (!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(sign == '+') stack.push(cur);
                else if(sign == '-') stack.push(- cur);
                else if(sign == '*') stack.push(stack.pop() * cur);
                else if(sign == '/') stack.push(stack.pop() / cur);
                sign = c;
            }
        }

        int res = 0;
        while(!stack.isEmpty())
            res += stack.pop();

        return res;
    }
}
