package prob281.zigzag.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import java.util.LinkedList;

/**
 * Created by yanya04 on 1/22/2018.
 */
public class ZigzagIterator {


    private Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {

        queue = new LinkedList<>();
        queue.offer(v1.iterator());
        queue.offer(v2.iterator());
    }

    public int next() {

        if(hasNext()){
            Iterator<Integer> iter = queue.poll();
            int res = iter.next();
            if(iter.hasNext())
                queue.offer(iter);
            return res;
        }
        return -1;
    }

    public boolean hasNext() {

        while(!queue.isEmpty() && !queue.peek().hasNext()){
            queue.poll(); // remove empty iterator
        }
        return !queue.isEmpty();
    }
}