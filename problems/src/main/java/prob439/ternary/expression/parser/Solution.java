package prob439.ternary.expression.parser;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String parseTernary(String expression) {

        // "F?1:T?4:5"

        if(expression == null || expression.length() == 0) return expression;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = expression.length() - 1; i > -1; i --){
            char c = expression.charAt(i);
            if(!stack.isEmpty() && stack.peek() == '?'){
                stack.pop(); // ?
                char first = stack.pop();
                stack.pop(); // :
                char second = stack.pop();
                if(c == 'T'){
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }
}