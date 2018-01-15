package prob172.factorial.trailing.zeroes;

/**
 * Created by yanya04 on 1/15/2018.
 */
public class Solution {
    /*
        how many 5 factors are there in a number?

        6!  = 6 * 5 * 4 * 3 * 2 * 1 = 720
        11! = 11 * 10 * 9 * 8 * 7 ... * 1 = 39916800                    2 x 5s
        16! = 16 * 15 * 14 ..... * 5 * ... * 1 = 20922789888000
            = 16 * (5 * 3) * ... (5 * 2) ... * 5 * ... * 1 =            3 x 5s

        26! = 26 * (5 * 5) * ... * (5 * 4)                              5 + 1 = 6 x 5s

    */
    public int trailingZeroes(int n) {

        return (n == 0)? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
