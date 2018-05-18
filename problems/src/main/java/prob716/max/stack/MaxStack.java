package prob716.max.stack;

import java.util.Stack;
import java.util.TreeMap;

/**
 *  Created by yanya04 on 5/16/2018.
 */
public class MaxStack {

    private TreeMap<Integer, Integer> tm;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        tm = new TreeMap<>((a, b) -> b - a);
    }

    public void push(int x) {
        stack.push(x);
        tm.put(x, tm.getOrDefault(x, 0) + 1);
    }

    public int pop() {
        int res = stack.pop();
        int count = tm.get(res);
        if(count == 1) tm.remove(res);
        else tm.put(res, count - 1);
        return res;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return tm.firstKey();
    }

    public int popMax() {
        int res = tm.firstKey();
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty() && stack.peek() != res){
            temp.push(stack.pop());
        }
        stack.pop();
        int count = tm.get(res);
        if(count == 1) tm.remove(res);
        else tm.put(res, count - 1);
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return res;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */