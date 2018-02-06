package prob295.find.median.from.data.stream;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yanya04 on 2/5/2018.
 */
public class MedianFinder {

    // small on the top, to save large values
    private PriorityQueue<Integer> small;

    // large on the top, to save small values
    private PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        large = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
    }

    public void addNum(int num) {
        if(small.isEmpty()){
            small.offer(num);
            return;
        }

        if(num > small.peek()){
            small.offer(num);
        } else {
            large.offer(num);
        }

        // balance;
        if(small.size() - large.size() > 1){
            large.offer(small.poll());
        } else if(large.size() - small.size() > 1){
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if(small.size() > large.size()){
            return small.peek().doubleValue();
        } else if(large.size() > small.size()){
            return large.peek().doubleValue();
        } else if(!large.isEmpty()){
            return (large.peek() + small.peek()) / 2.0;
        } else {
            // not possible;
            return 0.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
