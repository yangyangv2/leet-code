package prob150.evaluate.reverse.polish.notation;

import java.util.Stack;

/**
 * Created by yanya04 on 1/14/2018.
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){

            int op1 = 0;
            int op2 = 0;

            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    if(op2 == 0)
                        stack.push(0);
                    else
                        stack.push(op1 / op2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();

    }
}