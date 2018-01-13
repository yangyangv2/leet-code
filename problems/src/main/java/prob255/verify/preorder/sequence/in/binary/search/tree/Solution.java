package prob255.verify.preorder.sequence.in.binary.search.tree;

import java.util.Stack;

/**
 * Created by yanya04 on 1/13/2018.
 */
public class Solution {
    /*
        keep tracking the root, and

    */
    public boolean verifyPreorder(int[] preorder) {
        return array(preorder);
    }


    /*
                         5
                    3        8
                  2    4    6   9

            pre-order: 5 3 2 4 8 6 9

            num        5 3 2 4 8
            min        - - - 3 5
            top        0 1 2 0

    */
    private boolean array(int[] preorder){
        int top = -1;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < preorder.length; i ++){
            int num = preorder[i];
            if(num < min)
                return false;

            while( top != -1 && preorder[top] < num)
                min = preorder[top--];

            preorder[++top] = num;
        }
        return true;
    }

    private boolean stack(int[] preorder){
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;

        for(int i = 0; i < preorder.length; i ++){
            int num = preorder[i];
            if(num < min)
                return false;

            /*
                         5
                    3        8
                  2    4    6   9

            pre-order: 5 3 2 4 8 6 9
            wrong:     5 3 8 4 2 6 9


            num        5 4 8 3
            min        - - 5 X
            stack      5 5 8
                         4
            */
            while(!stack.isEmpty() && stack.peek() < num)
                min = stack.pop();

            stack.push(num);
        }
        return true;
    }
}
