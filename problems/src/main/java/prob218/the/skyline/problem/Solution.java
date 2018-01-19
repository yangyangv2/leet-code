package prob218.the.skyline.problem;

import java.util.*;

/**
 * Created by yanya04 on 1/19/2018.
 */
public class Solution {
    /*
                   s e h     s e h
        Input:  [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
        Output: [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]

        SweepLine:

        on start
        1. put the height into a Queue
        2. if new high, mark [s, high]

        on end

        1. remove the height from the Queue
        2. if new low, mark [e, low]

    */
    public List<int[]> getSkyline(int[][] buildings) {
        return tm(buildings);
    }


    /*
        TreeMap solution

        Space:      O(n);
        Complexity: O(nlog(n))
    */
    private List<int[]> tm(int[][] buildings){
        List<int[]> heights = new ArrayList<>();
        for(int[] b: buildings){
            int s = b[0];
            int e = b[1];
            int h = b[2];
            heights.add(new int[]{s, h, 0});    // start
            heights.add(new int[]{e, h, 1});    // end
        }

        Collections.sort(heights, (a, b) ->{
            // if coordinates are different, prior node go first
            if(a[0] != b[0]) return a[0] - b[0];

            // if coordinate are the same, start node go first over end node
            if(a[2] != b[2]) return a[2] - b[2];

            // if start node, then higher node go first
            if(a[2] == 0) return b[1] - a[1];

            // if end node, then lower node go first
            return a[1] - b[1];
        });

        List<int[]> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        map.put(0, 1);
        int pre = 0;
        for(int[] h: heights){

            if(h[2] == 0)
                map.put(h[1], map.getOrDefault(h[1], 0) + 1);
            else {
                int count = map.get(h[1]);
                if(count == 1){
                    map.remove(h[1]);
                } else {
                    map.put(h[1], count - 1);
                }
            }

            int cur = map.firstKey();
            if(cur != pre){
                result.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return result;
    }


    /*
        PriorityQueue Solution

        Space:      O(n);
        Complexity: O(n ^ 2)
    */
    private List<int[]> pq(int[][] buildings){
        List<int[]> heights = new ArrayList<>();
        for(int[] b: buildings){
            int s = b[0];
            int e = b[1];
            int h = b[2];
            heights.add(new int[]{s, h, 0}); // 0 indicate start
            heights.add(new int[]{e, h, 1}); // 1 indicate end
        }
        List<int[]> result = new ArrayList<>();

        Collections.sort(heights, (a, b) -> {
            // if coordinate is different, pick the earlier one
            if(a[0] != b[0]) return a[0] - b[0];

            // if one start, one end, start takes the prioirty
            if(a[2] != b[2]) return a[2] - b[2];

            // if start, take the highest
            if(a[2] == 0) return b[1] - a[1];

            // if end, take the lowest
            return a[1] - b[1];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(0);
        int pre = 0;
        for(int[] h: heights){
            if(h[2] == 0) queue.offer(h[1]);    // start point      // O(log(n))
            else queue.remove(h[1]);            // end point        // O(n)

            int cur = queue.peek();
            if(pre != cur){                     // max height is changed, add current coordinate into result
                result.add(new int[]{h[0], cur});
                pre = cur;
            } else {}                           // max height is unchanged, do nothing
        }
        return result;
    }


}