package prob277.find.the.celebrity;

import utils.graph.Relation;

import java.util.Stack;

/**
 * Created by yanya04 on 5/19/2018.
 * Modified by yanya04 on 5/28/2018.
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {

        int candidate = -1;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i ++)
            stack.push(i);

        int a = 0, b = 0;
        while(stack.size() > 1){
            a = stack.pop();
            b = stack.pop();
            if(knows(a, b)){
                // a is defintely not
                stack.push(b);
            } else {
                // b is defintely not
                stack.push(a);
            }
        }

        candidate = stack.pop();
        for(int i = 0; i < n; i ++){
            if(i == candidate) continue;

            if(!knows(i, candidate))
                return -1;

            if(knows(candidate, i))
                return -1;
        }
        return candidate;
    }
}