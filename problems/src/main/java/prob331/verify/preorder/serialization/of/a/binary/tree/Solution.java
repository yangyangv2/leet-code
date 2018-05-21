package prob331.verify.preorder.serialization.of.a.binary.tree;

import java.util.Stack;

/**
 *  Created by yanya04 on 5/19/2018.
 *  Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null) return true;
        String[] tokens = preorder.split(",");

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i ++){
            stack.push(tokens[i]);
            while(hasTwoHashes(stack)){
                stack.pop();
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
                stack.push("#");
            }
        }

        return stack.size() == 1 && "#".equals(stack.peek());
    }

    private boolean hasTwoHashes(Stack<String> stack){
        if(stack.size() < 2)
            return false;
        if("#".equals(stack.peek()) ){
            stack.pop();
            boolean twoHashes = "#".equals(stack.peek());
            stack.push("#");
            return twoHashes;
        } else{
            return false;
        }
    }
}