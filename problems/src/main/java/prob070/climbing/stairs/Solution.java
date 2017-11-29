package prob070.climbing.stairs;

public class Solution {

    // let s[i] be the number of ways to get the position i
    // s[i] = s[i - 1] + s[i - 2];

    // init
    // n = 0    s[n] = 0
    // n = 1    s[n] = 1
    // n = 2    s[n] = s[n - 1] + s[n - 2]   = 2
    // n = 3    s[n] = s[n - 1] + s[n - 2]   = 3
    //

    public int climbStairs(int n) {

        if(n <= 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;

        int[] s = new int[n + 1];
        s[0] = 0;
        s[1] = 1;
        s[2] = 2;
        for(int i = 3; i <= n; i ++)
            s[i] = s[i - 1] + s[i - 2];

        return s[n];
    }
}
