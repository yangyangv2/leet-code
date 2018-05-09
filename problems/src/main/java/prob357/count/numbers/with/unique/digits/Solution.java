package prob357.count.numbers.with.unique.digits;

/**
 * Created by yanya04 on 5/8/2018.
 */
public class Solution {

    /*
        f[i] be the number of unique digits with length i
        f[1] = 10
        f[2] = 9 * 9
        f[3] = 9 * 9 * 8
        f[4] = 9 * 9 * 8 * 7 ..

        f[10] = 9 * 9 * 8 * 7 ... * 2 * 1

        f[10] = f[9] * 1
        f[9] = f[8] * 2
        ...
        f[3] = f[2] * 8
        f[2] = 9 * 9

        f[11] = f[12] = f[13] = 0

        f[i] = f[i - 1] * (10 - i);

    */

    public int countNumbersWithUniqueDigits(int n) {

        if (n > 10) return 0;
        if (n == 0) return 1;
        if (n < 2) return 10;

        // (n >= 2 || n <= 10)
        int[] f = new int[10];
        f[0] = 10;
        f[1] = 9 * 9;
        int res = f[0] + f[1];

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] * (10 - i);
            res += f[i];
        }
        return res;
    }
}