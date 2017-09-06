package prob346.moving.average.from.data.stream;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yanya04 on 9/5/2017.
 */
public class MovingAverage {

    private Deque<Integer> queue;
    private int size;
    private double sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new ArrayDeque<>();
    }

    public double next(int val) {
        if (queue.size() == size) {
            queue.add(val);
            Integer oldest = queue.pollFirst();
            sum += val;
            sum -= oldest;

        } else {
            queue.add(val);
            sum += val;
        }
        return (sum / queue.size());
    }

    public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(3);
        double param_1 = obj.next(4);
    }

}
