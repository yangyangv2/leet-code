package prob155.min.stack;

import java.util.Stack;

/**
 * Created by yanya04 on 9/3/2017.
 */
public class MinStack {

//
    //using 2n Stack to track minimum element
    /** initialize your data structure here. */

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }
    /*
        stack [2,3,1]

        minStack [2,2,1]
    */
    public void push(int x) {
        if(! minStack.isEmpty() && minStack.peek() < x){
            minStack.push(minStack.peek());
        } else {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? Integer.MIN_VALUE : minStack.peek();
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
