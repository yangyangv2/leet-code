package prob632.smallest.range;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    /*
        [4,10,15,24,26]
        [0,9,12,20]
        [5,18,22,30]

         [8]
         [6]
         []

         start = 0
         end = 5;
         range = 5

         max = math.max(5, 6)
         max - peek() < range{
            start = peek()      4
            end = max;          6
         }
         range = 2

         max = max(6, 8)
         max - peek() = 8 - 5 = 3
         do nothing..
    */
    public int[] smallestRange(List<List<Integer>> nums) {

        // int[2] = {value, rowIndex}
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));


        int start = 0, end = 0, range = Integer.MAX_VALUE, max = Integer.MIN_VALUE, min = 0;
        for(List<Integer> list : nums){
            if(list.isEmpty())
                continue;
            pq.offer(list);
            max = Math.max(max, list.get(0));
        }


        while(pq.size() == nums.size()){

            min = pq.peek().get(0);
            if(range > max - min){
                start = min;
                end = max;
                range = end - start;
            }

            // get the list with smallest head
            List<Integer> list = pq.poll();
            // remove smallest
            list.remove(0);
            if(!list.isEmpty()){
                max = Math.max(list.get(0), max);
                pq.offer(list);
            }
        }

        return new int[]{start, end};

    }
}