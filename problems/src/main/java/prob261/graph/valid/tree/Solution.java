package prob261.graph.valid.tree;

import java.util.*;

/**
 * Modified by yanya04 On 5/5/2018.
 * Modified by yanya04 On 5/19/2018.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i ++)
            graph.put(i, new HashSet<Integer>());

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if(hasCycle(graph, visited, 0, 0)){
            return false;
        }

        for(int i = 0; i < n; i ++){
            if(!visited[i]) return false;
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, Set<Integer>> graph, boolean[] visited, int parent, int current){
        visited[current] = true;
        for(Integer neighbor: graph.get(current)){
            if(visited[neighbor] && parent != neighbor ||
                    !visited[neighbor] &&hasCycle(graph, visited, current, neighbor)){
                return true;
            }
        }
        return false;
    }
}
