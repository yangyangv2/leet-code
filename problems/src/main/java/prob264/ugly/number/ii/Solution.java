package prob264.ugly.number.ii;

public class Solution {
    public int nthUglyNumber(int n) {

        if(n < 6){
            return n;
        }

        int[] u = new int[n];


/*
    index   0 1 2 3 4 5 6 7 8  9
    value   1 2 3 4 5 6 8 9 10 12
*/

        int i2 = 0, i3 = 0, i5 = 0;
        u[0] = 1;
        for(int i = 1; i < n; i ++){
            int nextUgly = Math.min(u[i2] * 2, Math.min(u[i3] * 3, u[i5] * 5));
            if(nextUgly == u[i2] * 2) i2 ++;
            if(nextUgly == u[i3] * 3) i3 ++;
            if(nextUgly == u[i5] * 5) i5 ++;
            u[i] = nextUgly;
        }
        return u[n - 1];
    }
}