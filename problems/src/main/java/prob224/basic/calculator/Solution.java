package prob224.basic.calculator;

import java.util.Stack;

/**
 * Created by yanya04 on 1/19/2018.
 */
public class Solution {

    /*
        1 + 1 = 2
        2 - 1 + 2 = 3
        (1 + 2) - (3 + 4) = -4
    */
    public int calculate(String s) {


        // return twostack(s);
        return signplus(s);

    }


    private int signplus(String s){

        Stack<Integer> stack = new Stack<>();
        int res = 0, sign = 1;

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            switch(c){
                case '+':   sign = 1; break;
                case '-':   sign = -1; break;
                case ' ':   break;
                case '(':   stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                    break;
                case ')':   int temp = res;
                    sign = stack.pop();
                    res = stack.pop();
                    res += sign * temp;
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))){
                        sb.append(s.charAt(i + 1));
                        i ++;
                    }
                    res += sign * Integer.parseInt(sb.toString());
                    break;

            }
        }
        return res;
    }


    private int twostack(String s){
        Stack<Stack<Integer>> nums = new Stack<>();
        Stack<Stack<Character>> ops = new Stack<>();
        nums.push(new Stack<Integer>());
        ops.push(new Stack<Character>());

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            switch(c){
                case '+':
                case '-':   ops.peek().push(c);
                    break;
                case '(':   ops.push(new Stack<Character>());
                    nums.push(new Stack<Integer>());
                    break;
                case ')':   Stack<Integer> stack = nums.pop();
                    nums.peek().push(stack.pop());
                    ops.pop();
                    calculate(nums, ops);
                case ' ':   break;
                default:    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))){
                        sb.append(s.charAt(i + 1));
                        i ++;
                    }
                    nums.peek().push(Integer.parseInt(sb.toString()));
                    calculate(nums, ops);
                    break;
            }
        }
        calculate(nums, ops);
        return nums.peek().peek();
    }


    private void calculate(Stack<Stack<Integer>> nums, Stack<Stack<Character>> ops){
        if(!ops.peek().isEmpty()){
            char op = ops.peek().pop();
            int num2 = nums.peek().pop();
            int num1 = nums.peek().pop();
            if(op == '+') nums.peek().push(num1 + num2);
            else if(op == '-') nums.peek().push(num1 - num2);
        }
    }
}