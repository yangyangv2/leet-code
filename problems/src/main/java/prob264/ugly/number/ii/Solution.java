package prob264.ugly.number.ii;

import java.util.PriorityQueue;

/**
 * Modified by yanya04 On 5/2/2018.
 */

public class Solution {
    public int nthUglyNumber(int n) {
        // return pq(n);
        return dp(n);
    }


    private int dp(int n){

        if (n == 0) return 0;

        // x, y, z are the candidate indexes of ugly nums, can be used to mulply by 2, 3, 5 respectively
        // this indexes will move as we calculate the ugly nums
        int x = 0, y = 0, z = 0;
        int[] ugly = new int[n];

        // the first ugly number is 1
        ugly[0] = 1;

        int next = 0;
        for(int i = 1; i < n; i ++){
            next = Math.min(Math.min(ugly[x] * 2, ugly[y] * 3), ugly[z] * 5);
            if(next == ugly[x] * 2) x ++;
            if(next == ugly[y] * 3) y ++;
            if(next == ugly[z] * 5) z ++;
            ugly[i] = next;
        }

        return ugly[n - 1];

    }

    private int pq(int n){
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long temp = 1L;
        pq.offer(temp);
        for(int i = 1; i < n; i ++){
            temp = pq.poll();
            while(!pq.isEmpty() && pq.peek() == temp) temp = pq.poll();
            pq.offer(temp * 2);
            pq.offer(temp * 3);
            pq.offer(temp * 5);
        }
        return pq.peek().intValue();
    }
}