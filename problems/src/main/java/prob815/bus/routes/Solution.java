package prob815.bus.routes;

import java.util.*;

/**
 *  Created by yanya04 on 5/22/2018.
 *  Modified by yanya04 on 5/31/2018.
 */
public class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {

        if(S == T) return 0;

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < routes.length; i ++){
            for(int j = 0; j < routes[i].length; j ++){
                int bus = i, stop = routes[i][j];
                graph.putIfAbsent(stop, new HashSet<>());
                graph.get(stop).add(bus);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        Set<Integer> visited = new HashSet<>();

        int trip = 0, size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            trip ++;
            while(size -- > 0){
                int stop = queue.poll();
                for(Integer bus: graph.get(stop)){
                    if(!visited.add(bus)) continue;
                    int[] stops = routes[bus];
                    for(int i = 0; i < stops.length; i ++){
                        if(stops[i] == T) return trip;
                        queue.offer(stops[i]);
                    }
                }
            }
        }
        return -1;
    }
}