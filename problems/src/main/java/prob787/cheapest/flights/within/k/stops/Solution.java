package prob787.cheapest.flights.within.k.stops;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  Created by yanya04 on 6/3/2018.
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i ++)
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        for(int[] flight: flights){
            int s = flight[0], d = flight[1], c = flight[2];
            graph[s][d] = c;
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i = 0; i < n; i ++){
            if(src == i) continue;
            if(graph[src][i] < Integer.MAX_VALUE)
                queue.offer(new int[]{ graph[src][i], i, K });
        }

        while(!queue.isEmpty()){
            int[] next = queue.poll();
            int cost = next[0], label = next[1], stop = next[2];

            if(label == dst) return cost;

            if(stop > 0){
                for(int i = 0; i < n; i ++) {
                    if(graph[label][i] < Integer.MAX_VALUE){
                        queue.offer(new int[]{cost + graph[label][i], i, stop - 1});
                    }
                }
            }
        }
        return -1;
    }
}
