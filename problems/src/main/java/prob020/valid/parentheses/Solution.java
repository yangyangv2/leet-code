package prob020.valid.parentheses;

import java.util.Stack;

/**
 * Created by yanya04 on 9/3/2017.
 * Modified by yanya04 on 3/14/2017
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            char exp = '0';
            switch(c){
                case '}':
                    exp = '{';
                    break;
                case ']':
                    exp = '[';
                    break;
                case ')':
                    exp = '(';
                    break;
                default:
                    stack.push(c);
            }

            if(exp != '0'){
                if(stack.isEmpty()) return false;
                char start = stack.pop();
                if(start != exp) return false;
            }
        }
        return stack.isEmpty();
    }


}