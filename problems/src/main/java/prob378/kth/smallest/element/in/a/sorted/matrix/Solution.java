package prob378.kth.smallest.element.in.a.sorted.matrix;

import java.util.PriorityQueue;

/**
 * Created by yanya04 on 8/26/2017.
 * Modified by yanya04 on 5/2/2018.
 */
class Solution {
    private class Record{
        int val, x, y;
        Record(int val, int x, int y){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private Record getNext(int x, int y, int[][] matrix, boolean[][] visited){
        int m = matrix.length, n = matrix[0].length;
        if(x == m || y == n || visited[x][y]) return null;
        return new Record(matrix[x][y], x, y);
    }

    public int kthSmallest(int[][] matrix, int k) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;

        PriorityQueue<Record> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        pq.offer(new Record(matrix[0][0], 0, 0));
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Record next = null, right = null, down = null;
        for(int i = 1; i < k; i ++){
            next = pq.poll();
            visited[next.x][next.y] = true;
            right = getNext(next.x, next.y + 1, matrix, visited);
            if(right != null) {
                pq.offer(right);
                visited[right.x][right.y] = true;
            }
            down = getNext(next.x + 1, next.y, matrix, visited);
            if(down != null) {
                pq.offer(down);
                visited[down.x][down.y] = true;
            }
        }
        return pq.peek().val;
    }
}
