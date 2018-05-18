package prob227.basic.calculator.ii;

import java.util.Stack;

/**
 * Created by yanya04 on 1/19/2018.
 * Modified by yanya04 on 5/16/2018.
 */
public class Solution {
    /*
        Input: " 3 - 5 / 2 "
        Output: 5
    */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char c = 0, op = '+';
        for(int i = 0; i < s.length(); i ++){
            c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))){
                    sb.append(s.charAt(++i));
                }
                int num = Integer.parseInt(sb.toString());

                switch(op){
                    case '+': stack.push(num); break;
                    case '-': stack.push(- num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                }
            } else {
                op = c;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}