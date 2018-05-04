package prob668.kth.smallest.number.in.multiplication.table;

import java.util.PriorityQueue;

public class Solution {
    // record int[]: [0]-> val, [1] -> x, [2] -> y
    public int findKthNumber(int m, int n, int k) {
        return bs(m, n, k);
    }

    // m * log(m * n)
    private int bs(int m, int n, int k){
        int lo = 1, hi = m * n, mid = 0, count = 0;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            count = count(mid, m, n);
            if (count >= k) hi = mid;
            else lo = mid + 1;
            // System.out.println("<= lo = " + lo + ", hi = " + hi + ", mid = " + mid + ", count = " + count);
        }
        return lo;
    }

    private int count(int v, int m, int n){
        int temp = 0;
        for(int i = 1; i <= m; i ++){
            temp += Math.min(v / i, n);
        }
        return temp;
    }


    // priority queue solution, will get TLE
    // O(k log(k)), space: O(2k)
    private int pq(int m, int n, int k){

        if(m == 0 || n == 0) return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 1; i <= n; i ++){
            pq.offer(new int[]{i, 1, i});
        }
        int[] rec = null;
        for(int i = 1; i < Math.min(k, m * n); i ++){
            rec = pq.poll();
            if(rec[1] < m){
                pq.offer(new int[]{ rec[2] * (rec[1] + 1), rec[1] + 1, rec[2]});
            }
        }
        return pq.peek()[0];
    }

}