package prob264.ugly.number.ii;

import java.util.PriorityQueue;

/**
 * Modified by yanya04 On 5/2/2018.
 * Modified by yanya04 on 5/24/2018.
 */

public class Solution {
    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];

        // 1st = 1
        ugly[0] = 1;

        int x = 0, y = 0, z = 0, next = 0;
        for(int i = 1; i < n; i ++){
            next = Math.min(Math.min(ugly[x] * 2, ugly[y] * 3), ugly[z] * 5);
            if(next == ugly[x] * 2) x ++;
            if(next == ugly[y] * 3) y ++;
            if(next == ugly[z] * 5) z ++;
            ugly[i] = next;
        }
        return ugly[n - 1];
    }
}