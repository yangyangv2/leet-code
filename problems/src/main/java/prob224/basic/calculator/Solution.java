package prob224.basic.calculator;

import java.util.Stack;

/**
 * Created by yanya04 on 1/19/2018.
 * Modified by yanya04 on 5/16/2018.
 * Modified by yanyao4 on 5/20/2018.
 */
public class Solution {
    public int calculate(String s) {
        long sum = 0, sign1 = 1;
        Stack<Long> stack = new Stack<>(); // stack to simulate recursion

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                sb.setLength(0);
                sb.append(c);
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sb.append(s.charAt(++ i));
                }
                long num = Long.parseLong(sb.toString());

                sum += sign1 * num;

            } else if (c == '(') {
                // reserve calculation
                stack.push(sum);
                stack.push(sign1);

                // init
                sum = 0;
                sign1 = 1;

            } else if (c == ')') {

                sign1 = stack.pop();
                long num = sign1 * sum;

                sum = stack.pop();
                sum += num;

            } else if (c == '+' || c == '-') {
                sign1 = (c == '+') ? 1: -1;
            }
        }

        return (int) sum;
    }
}