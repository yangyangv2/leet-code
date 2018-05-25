package prob281.zigzag.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import java.util.LinkedList;

/**
 * Created by yanya04 on 1/22/2018.
 * Modified by yanya04 on 5/24/2018.
 */
public class ZigzagIterator {


    private Queue<Iterator> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if(v1 != null && !v1.isEmpty()) {
            queue.offer(v1.iterator());
        }
        if(v2 != null && !v2.isEmpty()) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {

        if(!hasNext()) {
            throw new RuntimeException("stack empty");
        }

        Iterator<Integer> iter = null;
        while(!queue.isEmpty()){
            iter = queue.poll();
            if(iter.hasNext())
                break;
        }

        int ret = -1;
        if(iter.hasNext()){
            ret = iter.next();
        }

        if(iter.hasNext()){
            queue.offer(iter);
        }
        return ret;
    }

    public boolean hasNext() {

        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */