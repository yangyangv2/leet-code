package prob261.graph.valid.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    /*
        Union Find
    */
    public boolean validTree(int n, int[][] edges) {


        if(n - 1 > edges.length)
            return false;

        int[] roots = new int[n];
        Arrays.fill(roots, - 1);

        for(int[] edge : edges){
            int x = find(roots, edge[0]);
            int y = find(roots, edge[1]);
            if(x == y) return false;
            roots[x] = y;
        }
        return true;
    }

    private int find(int[] roots, int x){
        while(roots[x] != -1){
            x = roots[x];
        }
        return x;
    }
}
