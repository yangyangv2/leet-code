package prob155.min.stack;

import java.util.Stack;

/**
 * Created by yanya04 on 9/3/2017.
 * Modified by yanya04 on 3/17/2018
 */
public class MinStack {

    private Stack<Integer> stack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min){
            stack.push(min);      // push old min
            min = x;
        }
        stack.push(x);            // push value
    }

    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
