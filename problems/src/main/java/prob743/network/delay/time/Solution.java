package prob743.network.delay.time;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *  Created by yanay04 on 5/26/2018.
 */
public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {

        int[][] graph = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i ++){
            Arrays.fill(graph[i], -1);
        }

        for(int[] time: times){
            graph[time[0]][time[1]] = time[2];
        }

        boolean[] visited = new boolean[N + 1];
        visited[0] = true;
        visited[K] = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(int i = 1; i <= N ; i ++){
            if(graph[K][i] >= 0) pq.offer(new int[]{i, graph[K][i]});
        }

        int label = 0, delay = 0, max = -1;
        int[] node = null;
        while(!pq.isEmpty()) {
            node = pq.poll();
            label = node[0];
            delay = node[1];
            if(visited[label]) continue;
            visited[label] = true;
            // the overall dealy of label is gurranteed to be minimum!

            max = Math.max(delay, max);

            for(int i = 1; i <=N; i ++ ){
                if(graph[label][i] >= 0 && !visited[i]){
                    pq.offer(new int[]{i, graph[label][i] + delay });
                }
            }
        }

        for(boolean v : visited){
            if(!v) return -1;
        }

        return max;
    }
}