package prob684.redundant.connection;

/**
 * Created by yanya04 on 2/7/2018.
 */
public class Solution {

    private static class UFSet {
        private int[] parents;
        UFSet(int n){
            parents = new int[n];
            for(int i = 0; i < n; i ++)
                parents[i] = i;
        }
        boolean union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            // already merged
            if(pu == pv) return false;

            parents[pv] = pu;
            return true;
        }

        int find(int u){
            while(parents[u] != u){
                parents[u] = parents[parents[u]];
                u = parents[u];
            }
            return u;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UFSet set = new UFSet(edges.length + 1);
        for(int[] edge: edges){
            if(!set.union(edge[0], edge[1])){
                return edge;
            }
        }
        return null;
    }
}