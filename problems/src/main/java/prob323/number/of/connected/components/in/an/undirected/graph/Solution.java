package prob323.number.of.connected.components.in.an.undirected.graph;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i ++){
            if(! visited[i]){
                visited[i] = true;
                count ++;
                dfs(i, graph, visited);
            }
        }
        return count;
    }

    private void dfs(int n, List<List<Integer>> graph, boolean[] visited){
        for(Integer next: graph.get(n)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, graph, visited);
            }
        }
    }
}