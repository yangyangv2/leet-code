package prob685.redundant.connection.ii;

/**
 *  Created by yanya04 on 6/2/2018.
 */
public class Solution {

    /*
        edge case with both multi-parent & cycle:

        [[2,1],[3,1],[4,2],[1,4]]
    */

    class UF{
        int[] parents;
        UF(int n) {
            parents = new int[n + 1];
            for(int i = 1; i <= n; i ++)
                parents[i] = i;
        }
        int[] cycle, mulp;

        void union(int[] edge){
            int x = find(edge[0]);
            int y = find(edge[1]);
            if(x != y){
                if(y != edge[1]){
                    // record the last edge which results in "multiple parents" issue
                    mulp = edge;
                } else {
                    parents[y] = x;
                }
            } else {
                // record last edge which results in "cycle" issue, if any.
                cycle = edge;
            }
        }

        int find(int x){
            while(parents[x] != x){
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);

        for (int[] e : edges){
            uf.union(e);
        }

        // if there is only one issue, return this one.
        if (uf.mulp == null) return uf.cycle;
        if (uf.cycle == null) return uf.mulp;

        // pick the node has multiple parents,
        // find the edge which is also part of the cycle
        for(int[] e: edges){
            if(e[1] == uf.mulp[1] && uf.find(e[1]) == uf.cycle[1])
                return e;
        }

        return new int[2];
    }
}