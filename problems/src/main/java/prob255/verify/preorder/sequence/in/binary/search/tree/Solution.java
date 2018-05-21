package prob255.verify.preorder.sequence.in.binary.search.tree;

import java.util.Stack;

/**
 * Created by yanya04 on 1/13/2018.
 * Modified by yanya04 on 5/19/2018.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length < 2) return true;

        Stack<Integer> stack = new Stack<>();
        stack.push(preorder[0]);
        int min = Integer.MIN_VALUE;

        for(int i = 1; i < preorder.length; i ++){

            while(!stack.isEmpty() && stack.peek() <= preorder[i]){
                min = stack.pop();
            }

            if(preorder[i] < min)
                return false;

            stack.push(preorder[i]);

        }
        return true;
    }
}