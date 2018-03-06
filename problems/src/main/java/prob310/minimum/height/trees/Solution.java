package prob310.minimum.height.trees;

import java.util.*;

/**
 * Created by yanya04 on 2/21/2018.
 */
public class Solution {
    /*
        1. turn edges into map
        2. using bfs
    */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // return solution1(n, edges);

        return solution2(n, edges);
    }


    /*
        Solution 2
        map-based removing leaves
    */

    private List<Integer> solution2(int n, int[][] edges){

        List<Integer> result = new ArrayList<>();
        if(n == 1) {
            result.add(0);
            return result;
        }

        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i ++) graph.add(new HashSet<>());

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        List<Integer> leaves = new ArrayList<>();

        for(int i = 0; i < graph.size(); i ++){
            if(graph.get(i).size() == 1) leaves.add(i);
        }


        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer leave: leaves){
                int next = graph.get(leave).iterator().next();
                graph.get(next).remove(leave);
                if(graph.get(next).size() == 1)
                    newLeaves.add(next);
            }
            leaves = newLeaves;
        }

        result.addAll(leaves);
        return result;
    }



    /*
        Solution 1

        map-based BFS, time exceeds
        Time Complexity O(n ^ 2)
    */

    private List<Integer> solution1(int n, int[][] edges){

        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            graph.add(new HashSet<Integer>());
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> result = new ArrayList<>();

        int minHeight = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++){
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            int height = 0;
            while(!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                while(!queue.isEmpty()){
                    int key = queue.poll();
                    visited.add(key);
                    list.addAll(graph.get(key));
                }

                height ++;
                if(height > minHeight) break;
                for(Integer sink : list){
                    if(!visited.contains(sink))
                        queue.offer(sink);
                }
            }

            if(height < minHeight){
                result.clear();
                minHeight = height;
            }
            if(height == minHeight){
                result.add(i);
            }
        }
        return result;
    }
}
