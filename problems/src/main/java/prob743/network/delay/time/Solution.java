package prob743.network.delay.time;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  Created by yanay04 on 5/26/2018.
 *  Modified by yanya04 on 6/3/2018.
 */
public class Solution {
    /*
        build graph <u, v> = cost
        use priorityqueue + dijkstra
    */
    public int networkDelayTime(int[][] times, int N, int K) {

        int[][] graph = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i ++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for(int[] time: times){
            int u = time[0], v = time[1], w = time[2];
            graph[u][v] = w;
        }

        // min heap sorted by cost
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

        for(int i = 1; i <= N; i ++){
            if(graph[K][i] < Integer.MAX_VALUE)
                queue.offer(new int[]{i, graph[K][i]});
        }

        boolean[] visited = new boolean[N+1];
        visited[K] = true;
        visited[0] = true;

        int max = -1;
        while(!queue.isEmpty()){

            int[] node = queue.poll();
            int label = node[0];
            int delay = node[1];
            if(visited[label]) continue;
            visited[label] = true;

            max = Math.max(max, delay);

            for(int i = 1; i <= N; i ++){
                if(graph[label][i] == Integer.MAX_VALUE || visited[i]) continue;
                queue.offer(new int[]{i, graph[label][i] + delay});
            }
        }

        for(int i = 1; i <= N; i ++)
            if(!visited[i]) return -1;

        return max;

    }
}