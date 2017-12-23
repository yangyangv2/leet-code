package prob032.longest.valid.parentheses;

import java.util.Stack;

public class Solution {

    /*
                012345
        case 1  )()())

                012345678
        case 2  )((()()))

                012345
        case 3  )(((()
    */
    public int longestValidParentheses(String s) {

        int start = 0, max = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i ++){

            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            } else {
                // )
                if(stack.isEmpty()){
                    start = i + 1;
                } else {
                    int last = stack.pop();
                    int len = 0;
                    if(stack.isEmpty()){
                        len = i - start + 1;
                    } else {
                        len = i - stack.peek();
                    }
                    max = Math.max(len, max);
                }
            }
        }




        return max;
    }
}