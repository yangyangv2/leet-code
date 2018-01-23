package prob341.flatten.nested.list.iterator;

import utils.nestedinteger.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanya04 on 1/22/2018.
 */
public class NestedIterator implements Iterator<Integer>
{
    private Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for(int i = nestedList.size() - 1; i >= 0; i --){
            stack.push(nestedList.get(i));
        }
    }
    @Override
    public Integer next() {

        if(hasNext()){
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {

        while(!stack.isEmpty()){
            NestedInteger cur = stack.peek();
            if(cur.isInteger()) return true;
            List<NestedInteger> list = stack.pop().getList();
            for(int i = list.size() - 1; i >= 0; i --)
                stack.push(list.get(i));
        }
        return false;
    }
}
