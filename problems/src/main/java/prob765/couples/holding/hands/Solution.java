package prob765.couples.holding.hands;

/**
 *  Created by yanya04 on 5/26/2018.
 */
public class Solution {
    private class UF {
        private int[] parents;
        public int count;
        UF(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            count = n;
        }

        private int find(int i) {
            if (parents[i] == i) {
                return i;
            }
            parents[i] = find(parents[i]);
            return parents[i];
        }

        public void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a != b) {
                parents[a] = b;
                count--;
            }
        }
    }
    public int minSwapsCouples(int[] row) {
        int N = row.length/ 2;
        UF uf = new UF(N);
        for (int i = 0; i < N; i++) {
            int a = row[2*i];
            int b = row[2*i + 1];
            // connecting this couple pairs
            // if we see people from the same pair of couple are
            // trying to connect, we can skip it.
            uf.union(a/2, b/2);
        }
        return N - uf.count;
    }
}
