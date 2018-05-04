package prob378.kth.smallest.element.in.a.sorted.matrix;

import java.util.PriorityQueue;

/**
 * Created by yanya04 on 8/26/2017.
 * Modified by yanya04 on 5/2/2018.
 * Modified by yanya04 on 5/4/2018.
 */
public class Solution {

    class Tuple {
        int val, x, y;
        Tuple(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i = 0; i < n; i ++){
            pq.offer(new Tuple(matrix[0][i], 0, i));
        }

        Tuple tuple = null;

        for(int i = 1; i < Math.min(k, m * n); i ++){
            tuple = pq.poll();
            if(tuple.x < m - 1){
                pq.offer(new Tuple(matrix[tuple.x + 1][tuple.y], tuple.x + 1, tuple.y));
            }
        }

        return pq.peek().val;
    }
}
