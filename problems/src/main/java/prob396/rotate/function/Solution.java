package prob396.rotate.function;

/**
 * Created by yanya04 on 3/17/2018.
 */
public class Solution {
/*
    F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
    F(1) = (1 * 4) + (2 * 3) + (3 * 2) + (0 * 6) = 0 + 4 + 6 + 6 = 16
            + B[0]     +B[1]     +B[2]      - (n - 1) * B[n];
    F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
            + B[0]     +B[1]     +B[2]      - (n - 1) * last


    F(1) - F(0) = B[0] + B[1] + ..... - (n - 1) * B[n]

    F(2) - F(1) = B[0] + B[1] + ..... - (n - 1) * B[n - 1] + B[n]

    F(3) - F(2) = B[0] + B[1] + ..... - (n - 1) * B[n - 2] + B[n] + B[n - 1]

                    |----------------------rotate sum ------------------|

    1. get a sum[n]
    2. get init of F[n]
    3. rotate

    Complexity is O(n), space is O(n)

*/
    public int maxRotateFunction(int[] A) {

        if(A == null || A.length == 0) return 0;

        int n = A.length;
        int sum = 0, init = 0;
        for(int a: A)
            sum += a;
        for(int i = 0; i < n; i ++)
            init += i * A[i];

        int cur = init, max = init;
        for(int i = 1; i < n; i ++){
            cur = cur + sum - n * A[n - i];
            max = Math.max(max, cur);
        }
        return max;
    }
}