package prob215.kth.largest.element.in.an.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yanya04 on 8/12/2017.
 */
public class Solution1 {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(Integer num: new int[]{5,4,3,2,1}){
            pq.offer(num);
            System.out.println(pq);
            if(pq.size() > 2){
                System.out.println("remove " + pq.poll());
            }
        }
        System.out.println("peek " + pq.peek());

    }


    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Integer num : nums){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
