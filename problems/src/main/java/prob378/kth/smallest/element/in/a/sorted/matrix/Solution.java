package prob378.kth.smallest.element.in.a.sorted.matrix;

import java.util.PriorityQueue;

/**
 * Created by yanya04 on 8/26/2017.
 * Modified by yanya04 on 5/2/2018.
 * Modified by yanya04 on 5/4/2018.
 * Modified by yanya04 on 5/15/2018.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < n ; i ++){
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        int[] cur = null;
        for(int i = 0; i < k; i ++){
            cur = pq.poll();
            int x = cur[1], y = cur[2];
            if(y + 1 < n){
                pq.offer(new int[]{matrix[x][y + 1], x, y + 1});
            }
        }
        return cur == null ? -1 : cur[0];
    }
}