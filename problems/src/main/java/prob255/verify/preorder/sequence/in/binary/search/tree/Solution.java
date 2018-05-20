package prob255.verify.preorder.sequence.in.binary.search.tree;

import java.util.Stack;

/**
 * Created by yanya04 on 1/13/2018.
 * Modified by yanya04 on 5/19/2018.
 */
public class Solution {
/*
         5
        / \
       2   6
      / \
     1   3
         (when turn right, 3 is the lower bound)
*/

    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0)
            return true;
        int lowerbound = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < preorder.length; i ++){
            while(!stack.isEmpty() && preorder[i] > stack.peek() ){
                lowerbound = stack.pop();
            }
            if(preorder[i] < lowerbound)
                return false;

            stack.push(preorder[i]);
        }
        return true;
    }
}
