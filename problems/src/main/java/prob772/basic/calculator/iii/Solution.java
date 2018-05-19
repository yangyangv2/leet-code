package prob772.basic.calculator.iii;

import java.util.Stack;

/**
 *  Created by yanya04 on 5/19/2018.
 */
public class Solution {

    // "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
    public int calculate(String s) {
        long sum = 0, mul = 1, sign1 = 1, sign2 = 1;
        Stack<Long> stack = new Stack<>();
        char c = 0;
        for(int i = 0; i < s.length(); i ++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    sb.append(s.charAt(++ i));
                }
                long num = Long.parseLong(sb.toString());
                mul = sign2 == 1 ? mul * num : mul / num;
            } else if(c == '('){

                stack.push(sum);
                stack.push(sign1);
                stack.push(mul);
                stack.push(sign2);

                sum = 0;
                sign1 = 1;
                mul = 1;
                sign2 = 1;

            } else if(c == ')'){
                long num = sum + sign1 * mul;

                sign2 = stack.pop();
                mul  = stack.pop();
                sign1 = stack.pop();
                sum = stack.pop();

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