package prob070.climbing.stairs;


/**
 * Modified by yanya04 on 5/7/2018.
 */
public class Solution {
    /*
        f[n]: number of ways to get n;
        f[0] = 1;
        f[1] = 1;
        f[2] = f[1] + f[0]
        f[n] = f[n - 1] + f[n - 2]
    */
    public int climbStairs(int n) {

        int[] f = new int[2];
        f[0] = 1; f[1] = 1;

        for(int i = 2; i <= n; i ++){
            f[i % 2] = f[(i - 1) % 2] + f[(i - 2) % 2];
        }
        return f[n % 2];
    }
}