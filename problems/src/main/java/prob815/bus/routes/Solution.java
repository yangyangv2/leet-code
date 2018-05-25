package prob815.bus.routes;

import java.util.*;

/**
 *  Created by yanya04 on 5/22/2018.
 */
public class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int stop = 0;
        for(int bus = 0; bus < routes.length; bus ++){
            for(int i = 0; i < routes[bus].length; i ++){
                stop = routes[bus][i];
                graph.putIfAbsent(stop, new ArrayList<>());
                graph.get(stop).add(bus);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int size = 0, trip = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            // loop through all the stops on the current route
            trip ++;
            while(size -- > 0){
                stop = queue.poll();
                for(Integer bus: graph.get(stop)){
                    if(!visited.add(bus))
                        continue;
                    for(int i = 0; i < routes[bus].length; i ++){
                        if(routes[bus][i] == T){
                            return trip;
                        } else {
                            queue.offer(routes[bus][i]);
                        }
                    }
                }
            }
        }
        return -1;
    }
}