package prob020.valid.parentheses;

import java.util.Stack;

/**
 * Created by yanya04 on 9/3/2017.
 */
public class Solution {

    /*
        use stack
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(isStarting(c)){
                stack.push(c);
            } else if (isClosing(c)){
                if(stack.isEmpty()) return false;
                switch(c){
                    case ']':
                        if(stack.peek() == '[') stack.pop();
                        else stack.push(c); break;
                    case '}':
                        if(stack.peek() == '{') stack.pop();
                        else stack.push(c); break;
                    case ')':
                        if(stack.peek() == '(') stack.pop();
                        else stack.push(c); break;
                    default:
                        break;
                }
            }
        }
        return stack.isEmpty();
    }


    public boolean isStarting(char c){
        return "([{".indexOf(c) > -1;
    }

    public boolean isClosing(char c){
        return "])}".indexOf(c) > -1;
    }


}