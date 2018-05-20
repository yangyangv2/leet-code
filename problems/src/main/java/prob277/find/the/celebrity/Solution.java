package prob277.find.the.celebrity;

import utils.graph.Relation;

import java.util.Stack;

/**
 * Created by yanya04 on 5/19/2018.
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n == 0 ) return -1;
        if(n == 1 ) return 0;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i ++)
            stack.push(i);

        while(stack.size() > 1){
            int a = stack.pop();
            int b = stack.pop();
            if(knows(a, b)){
                // a knows b, a cannot be the celebrity
                stack.push(b);
            } else {
                // a does not b, so b cannot be the celebrity
                stack.push(a);
            }
        }

        int last = stack.pop();
        for(int i = 0; i < n; i ++){
            if(i == last) continue;
            if(knows(last, i))
                return -1;
            if(!knows(i, last))
                return -1;
        }
        return last;

    }
}