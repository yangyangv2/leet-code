package prob279.perfect.squares;

import java.util.Arrays;

public class Solution {

/*
    DP

    res: number of result

            0 1 2 3 ... n
    res[i]  0 1
*/

    public int numSquares(int n) {

        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for(int i = 1; i <= n; i ++)
            for(int j = 1; j * j <= i; j ++)
                res[i] = Math.min(res[i], res[i - j * j] + 1);

        return res[n];
    }
}