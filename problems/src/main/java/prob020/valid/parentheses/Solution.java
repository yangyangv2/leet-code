package prob020.valid.parentheses;

import java.util.Stack;

/**
 * Created by yanya04 on 9/3/2017.
 * Modified by yanya04 on 3/14/2018.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){

            switch(c){
                case    '{' :   stack.push('}'); break;
                case    '(' :   stack.push(')'); break;
                case    '[' :   stack.push(']'); break;
                default     :   if (stack.isEmpty() || stack.peek() != c){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}