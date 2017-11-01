package prob261.graph.valid.tree;

import java.util.ArrayList;

public class Solution {
    public boolean validTree(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);

        // init adjacent list
        for(int i = 0; i < n; i ++){
            adjList.add(new ArrayList<Integer>());
        }

        // fill with edges
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // init visite map
        boolean[] visits = new boolean[n];

        // find cycle

        if(hasCycle(0, -1, visits, adjList)){
            return false;
        }

        // make sure all nodes are visited
        for(Boolean visited: visits){
            if(visited == false) return false;
        }

        return true;
    }


    private boolean hasCycle(int node, int parent, boolean[] visits, ArrayList<ArrayList<Integer>> adjList){
        visits[node] = true;
        for(Integer next: adjList.get(node)){

            if(visits[next] && next != parent){
                return true;
            }

            if(!visits[next] && hasCycle(next, node, visits, adjList)){
                return true;
            }
        }

        return false;
    }

}
